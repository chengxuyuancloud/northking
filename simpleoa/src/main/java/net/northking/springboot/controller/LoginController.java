package net.northking.springboot.controller;

import net.northking.springboot.entities.User;
import net.northking.springboot.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * author Chamberalin
 * version V1.0
 * 2021/7/29 15:57
 * Description:
 */
@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {
        // 获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        if ((StringUtils.isEmpty(username)) || (StringUtils.isEmpty(password))) {
            return "用户名或密码不能为空!";
        }
        try {
            // 执行登录操作
            subject.login(new UsernamePasswordToken(username,password));
            // 认证通过后直接跳转到index.jsp
            return "成功";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "用户名错误~";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return "密码错误~";
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果认证失败仍然回到登录页面
        return "失败";


    }
    /**
     * 用户注册
     * @param
     * @return
     */
    @RequestMapping("regist")
    @ResponseBody
    public String register(HttpSession session, @RequestParam String username, @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            userService.register(user);
            return "注册成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "失败";
    }
}
