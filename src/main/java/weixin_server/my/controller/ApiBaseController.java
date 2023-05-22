package weixin_server.my.controller;

import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.extension.api.R;

public class ApiBaseController {

    public ApiBaseController() {
    }
    protected <T> R<T> successHandler(T t) {
        return this.executeHandler(HttpStatus.HTTP_OK,"success", t);
    }

    protected <T> R<T> failHandler(T t) {
        return this.executeHandler(HttpStatus.HTTP_INTERNAL_ERROR,"file", t);
    }

    public <T> R<T> executeHandler(int code,String msg,T t){
        R<T> r = new R();
        r.setData(t);
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
