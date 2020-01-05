package cn.edu.cqupt.evdchain.controller;

import cn.edu.cqupt.evdchain.entity.User;
import cn.edu.cqupt.evdchain.pojo.UserInfo;
import cn.edu.cqupt.evdchain.servicel.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserServiceI userService;

    @Autowired
    public UserController(UserServiceI userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    String register(User user) {
        return userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    UserInfo login(User user) {
        return userService.login(user);
    }

    @RequestMapping(value = "/ban", method = RequestMethod.POST)
    public @ResponseBody
    String ban(User user) {
        return userService.ban(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    String delete(User user) {
        return userService.delete(user);
    }
}
