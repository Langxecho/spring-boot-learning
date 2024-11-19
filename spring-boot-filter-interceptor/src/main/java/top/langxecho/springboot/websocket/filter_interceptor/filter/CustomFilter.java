package top.langxecho.springboot.websocket.filter_interceptor.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/11/4 13:39
 */
@Slf4j

public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       log.info("CustomFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("请求处理中");
        filterChain.doFilter(servletRequest,servletResponse);
        //在响应处理之后，执行的逻辑
        log.info("响应后处理中");
    }

    @Override
    public void destroy() {
       log.info("CustomFilter 销毁");
    }
}
