package com.zjq.springboot.controller;

import com.zjq.springboot.entity.LoginData;
import com.zjq.springboot.entity.User;
import com.zjq.springboot.mapper.UserMapper;
import com.zjq.springboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping("/info")
    public List<User> index(){
        return userMapper.findAll();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody User user){
        System.out.println("----user----"+user);
        user.setCreatedTime(new Date());
        return userService.saveUser(user);
    }

    @PostMapping("/delete")
    public boolean delete(Long userId){
        System.out.println(userId);
        return userMapper.deleteById(userId) == 1;
    }

    @PostMapping("/upload")
    public boolean upload(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public LoginData login(@RequestBody User user){
        System.out.println("USER:--------"+user);
        User tempUser = userMapper.login(user.getUserName(), user.getPassword());
        if (tempUser == null){
            return new LoginData(false, null);
        }else {
            return new LoginData(true, tempUser.getUserName());
        }
    }

    @PostMapping("/getById")
    public User getUser(Long userId){
        System.out.println("---userid---"+userId);
        return userMapper.selectById(userId);
    }
}
