
package top.mqxu.week09.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class LogFilter implements Filter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LogFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        String path = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();
        String clientIp = httpRequest.getRemoteAddr();
        String queryString = httpRequest.getQueryString();
        String timestamp = LocalDateTime.now().format(FORMATTER);
        
        log.info("请求到达 - Time: {}, Method: {}, Path: {}, IP: {}, Query: {}", 
                timestamp, method, path, clientIp, queryString);
        
        long startTime = System.currentTimeMillis();
        
        try {
            filterChain.doFilter(request, response);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            log.info("请求完成 - Time: {}, Method: {}, Path: {}, Duration: {}ms", 
                    LocalDateTime.now().format(FORMATTER), method, path, duration);
        }
    }

    @Override
    public void destroy() {
        log.info("LogFilter 销毁");
    }
}
