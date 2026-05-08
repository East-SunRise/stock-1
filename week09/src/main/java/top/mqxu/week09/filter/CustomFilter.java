
package top.mqxu.week09.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomFilter 初始化完成");
    }

    @Override
    public void destroy() {
        log.info("CustomFilter 销毁完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("执行 CustomFilter 逻辑");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("CustomFilter 执行完毕，返回响应");
    }
}
