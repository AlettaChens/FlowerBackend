package com.example.demo.service;


import com.example.demo.entity.User;


public interface UserService {
    int register(String username, String password);

    User login(String username, String password);

    int updateAvatar(String avatar, Integer id);

    int updateUserInfo(String username, String pwd, Integer id);
}
