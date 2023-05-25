package com.my.config.shiro;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.my.exception.ExceptionThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

//JWT的工具类，用于decode，encode和识别token
@Component
@Slf4j
public class JwtUtil {
    //密钥
     @Value("${emos.jwt.secret}")
    private String secret;
     //过期时间（天）
    @Value("${emos.jwt.expire}")
    private int expire;
    public String createToken(Long userId) {
            Date date = DateUtil.offset(new Date(), DateField.DAY_OF_YEAR,
                    expire).toJdkDate();
            Algorithm algorithm = Algorithm.HMAC256(secret); //创建加密算法对象
            JWTCreator.Builder  builder = com.auth0.jwt.JWT.create();
            String token = builder.withClaim("userId",
                    userId).withExpiresAt(date).sign(algorithm);
            return token;
             }
     public Long getUserId(String token) {
            try {
                 DecodedJWT jwt = com.auth0.jwt.JWT.decode(token);
                 return jwt.getClaim("userId").asLong();
                } catch (Exception e) {
                 throw new ExceptionThrows("令牌无效");
                 }
             }
     public void verifierToken(String token) {
             Algorithm algorithm = Algorithm.HMAC256(secret); //创建加密算法对象
             JWTVerifier verifier = JWT.require(algorithm).build();
             verifier.verify(token);
             }
}
