package com.example.demo.repo;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class UserRepo implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int register(String username, String password) {
        return userMapper.register(username, password);
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }


    @Override
    public int updateAvatar(String avatar, Integer id) {
        return userMapper.updateAvatar(avatar, id);
    }

    @Override
    public int updateUserInfo(String username, String pwd, Integer id) {
        return userMapper.updateUserInfo(username, pwd, id);
    }
}
