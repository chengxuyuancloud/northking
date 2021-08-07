package net.northking.springboot.shiro;

import net.northking.springboot.entities.User;
import net.northking.springboot.service.UserService;
import net.northking.springboot.util.ApplicationContextUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.ObjectUtils;

/**
 * 自定义realm
 */
public class CustomerRealm extends AuthorizingRealm {
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取当前登录的主题
        String principal = (String) token.getPrincipal();
        // 由于CustomerRealm并没有交由工厂管理，故不能诸如UserService
        UserService userService = (UserService) ApplicationContextUtil.getBean("userService");
        User user = userService.findUserByUserName(principal);
        if(!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), new CustomerByteSource("8"),this.getName());
        }
        return null;
    }
}
