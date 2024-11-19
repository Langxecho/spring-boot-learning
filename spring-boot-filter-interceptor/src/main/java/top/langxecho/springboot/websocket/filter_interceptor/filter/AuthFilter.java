package top.langxecho.springboot.websocket.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/11/4 14:09
 */
@Slf4j
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authToken = request.getHeader("Authorization");
        if("hello".equals(authToken)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("unAuthorized!!!");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
