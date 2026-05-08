
package top.mqxu.week09.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class AuthFilter implements Filter {

    private static final Map<String, UserInfo> USER_DB = new HashMap<>();
    private static final Map<String, List<String>> ROLE_PERMISSIONS = new HashMap<>();

    static {
        USER_DB.put("admin-token", new UserInfo("admin", "ROLE_ADMIN", Arrays.asList("read", "write", "delete")));
        USER_DB.put("user-token", new UserInfo("user", "ROLE_USER", Arrays.asList("read")));
        USER_DB.put("guest-token", new UserInfo("guest", "ROLE_GUEST", Arrays.asList()));

        ROLE_PERMISSIONS.put("/api/test", Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
        ROLE_PERMISSIONS.put("/api/admin", Arrays.asList("ROLE_ADMIN"));
        ROLE_PERMISSIONS.put("/api/public", Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST"));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("AuthFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=UTF-8");
        
        String path = httpRequest.getRequestURI();
        String authToken = httpRequest.getHeader("Authorization");
        
        log.debug("认证过滤器处理请求 - Path: {}, Token: {}", path, authToken);

        if (isPublicPath(path)) {
            log.debug("公共路径，跳过认证");
            chain.doFilter(request, response);
            return;
        }

        if (authToken == null || authToken.isEmpty()) {
            log.warn("未提供认证令牌 - Path: {}", path);
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("{\"code\": 401, \"message\": \"未认证，请提供Authorization令牌\"}");
            return;
        }

        UserInfo userInfo = USER_DB.get(authToken);
        if (userInfo == null) {
            log.warn("无效的认证令牌 - Token: {}", authToken);
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("{\"code\": 401, \"message\": \"认证失败，无效的令牌\"}");
            return;
        }

        log.info("认证成功 - 用户: {}, 角色: {}", userInfo.getUsername(), userInfo.getRole());

        if (!hasPermission(path, userInfo.getRole())) {
            log.warn("未授权访问 - 用户: {}, 角色: {}, 路径: {}", 
                    userInfo.getUsername(), userInfo.getRole(), path);
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.getWriter().write("{\"code\": 403, \"message\": \"未授权，当前角色无权限访问此资源\"}");
            return;
        }

        log.info("授权成功 - 用户: {}, 角色: {}, 路径: {}", 
                userInfo.getUsername(), userInfo.getRole(), path);
        
        httpRequest.setAttribute("userInfo", userInfo);
        chain.doFilter(request, response);
    }

    private boolean isPublicPath(String path) {
        return path.endsWith("/api/public") || path.endsWith("/api/health");
    }

    private boolean hasPermission(String path, String role) {
        List<String> allowedRoles = ROLE_PERMISSIONS.get(path);
        if (allowedRoles == null) {
            return true;
        }
        return allowedRoles.contains(role);
    }

    @Override
    public void destroy() {
        log.info("AuthFilter 销毁");
    }

    public static class UserInfo {
        private String username;
        private String role;
        private List<String> permissions;

        public UserInfo(String username, String role, List<String> permissions) {
            this.username = username;
            this.role = role;
            this.permissions = permissions;
        }

        public String getUsername() {
            return username;
        }

        public String getRole() {
            return role;
        }

        public List<String> getPermissions() {
            return permissions;
        }
    }
}
