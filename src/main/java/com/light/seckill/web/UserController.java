package com.light.seckill.web;

import com.light.seckill.db.dao.UserDao;
import com.light.seckill.db.po.User;
import com.light.seckill.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Map;


@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserDao userDao;

    @Resource
    UserService userService;

    @Resource
    PasswordEncoder passwordEncoder;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/signup")
    public String userSignUp() {
        return "register";
    }


    @RequestMapping("/signupAction")
    public String userSignUpAction(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("psw") String password,
            Map<String, Object> resultMap)
            throws ParseException {
        if (userService.isUserExist(email)) {
            return "register_exist";
        }
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(email);
        user.setPassword(passwordEncoder.encode(password));
        userDao.insertUser(user);
        resultMap.put("user", user);
        return "register_success";
    }


    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }
}
