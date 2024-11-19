package top.langxecho.springboot.websocket.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/11/4 13:53
 */
@Slf4j
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.info("loggingFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        String clientIp = request.getRemoteAddr();
        LocalDateTime beginTime = LocalDateTime.now();
        log.info("请求已经到达过滤器:path:{},clientIp:{},beginTime:{}",path,clientIp,beginTime);
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("过滤器响应处理完毕:path:{},endTime:{}",path,LocalDateTime.now());


    }

    @Override
    public void destroy() {
        log.info("loggingFilter销毁");

    }
}
