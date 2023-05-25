package com.my.config.shiro;

import org.springframework.stereotype.Component;

//保存token类
@Component
public class ThreadLocalToken {
    private final ThreadLocal<String> local = new ThreadLocal();

    public void setToken(String token){
        local.set(token);
    }

    public String getToken(){
        return local.get();
    }

    public void clear(){
        local.remove();
    }
}
