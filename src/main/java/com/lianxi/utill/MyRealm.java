package com.lianxi.utill;

import com.lianxi.entity.user.WxbMemeber;
import com.lianxi.service.user.WxbMemeberService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {
    @Resource
    private WxbMemeberService wxbMemeberService;
    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //使用用户密码方式验证
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;
        //得到输入的用户名
        String username = usernamePasswordToken.getUsername();
        //得到输入的密码
        String password = new String(usernamePasswordToken.getPassword());
        //登陆
        WxbMemeber wxbMemeber = wxbMemeberService.findDengLu(username);
        if(wxbMemeber!=null){
            if(Md5.md5(password,wxbMemeber.getMemeberSalt()).equals(wxbMemeber.getPassword())){
                SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(wxbMemeber, password, getName());
                return authenticationInfo;
            }else {
                throw new AccountException("密码错误");
            }
        }else {
            throw new UnknownAccountException("未知的账号");
        }
    }
}
