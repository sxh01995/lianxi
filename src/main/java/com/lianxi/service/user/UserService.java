package com.lianxi.service.user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void login(String account,String password)throws Exception{
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject);
        subject.login(new UsernamePasswordToken(account,password));
    }
}
