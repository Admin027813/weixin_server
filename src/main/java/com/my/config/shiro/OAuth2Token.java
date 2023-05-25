package com.my.config.shiro;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

//自定义的token类，用以代替shiro原生的UsernamePasswordToken
@Data
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
