package top.langxecho.springboot.exception.service;

import org.springframework.stereotype.Service;
import top.langxecho.springboot.exception.exception.ServerException;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/15 13:51
 */


@Service
public class ExceptionService {
    /**
     * 模拟未登录异常
     */
    public void unAuthorizedError() {
        throw new ServerException("没有登录");
    }
    /**
     *模拟系统异常
     */
    public void systemError() {
        throw new ServerException("系统异常");
    }
}