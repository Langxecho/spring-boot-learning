package top.langxecho.springboot.configure.utils;

import cn.hutool.jwt.JWTUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import top.langxecho.springboot.configure.config.JwtConfig;

import java.util.Date;
import java.util.Map;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 19:58
 */
@Component
public class JwtUtil {
    @Resource
    private JwtConfig jwtConfig;

    public String generateToken(Map<String,Object> claims){
        claims.put("exp",new Date(System.currentTimeMillis() + jwtConfig.getExpiration()));
        return JWTUtil.createToken(claims,jwtConfig.getSecret().getBytes());
    }

    public boolean validateToken(String token){
        return JWTUtil.verify(token,jwtConfig.getSecret().getBytes());
    }
}
