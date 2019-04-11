package com.lianxi.controller.user;

import com.lianxi.entity.utill.Help;
import com.lianxi.service.user.UserService;
import com.lianxi.service.user.WxbMemeberService;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Memeber")
public class WxbMemeberController {
    @Resource
    private UserService userService;
    @Resource
    private WxbMemeberService wxbMemeberService;
    @RequestMapping("/login")
    public Help login(String username, String pwd){
        try {
            userService.login(username,pwd);
            return new Help("01","登陆成功");
        }catch (UnknownAccountException u){
            u.printStackTrace();
            return new Help("02","用户名或密码错误");
        }catch (AccountException a){
            a.printStackTrace();
            return new Help("02","用户名或密码错误");
        } catch (Exception e) {
            e.printStackTrace();
            return new Help("03","未知错误请联系管理员");
        }
    }
}
