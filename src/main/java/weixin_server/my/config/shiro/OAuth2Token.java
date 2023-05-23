package weixin_server.my.config.shiro;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

@Data
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
