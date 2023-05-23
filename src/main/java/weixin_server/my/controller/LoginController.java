package weixin_server.my.controller;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/login")
public class LoginController extends ApiBaseController{

    @PostMapping("/login")
    @ApiOperation("登录接口")
    public R<String> login(@RequestBody String name){
        //todo 验证对象是非为空，然后验证账号
        //todo 验证密码
        //todo 获取token
        //todo 保存token并且返回token
        return successHandler("");
    }
}
