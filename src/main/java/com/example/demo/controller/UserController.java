package com.example.demo.controller;


import com.example.demo.service.UserService;
import com.example.demo.utils.FileUploadUtils;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value = "user")
@Api(value = "用户相关接口", description = "用户相关接口")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultMap register(String username, String password) {
        if (userService.register(username, password) == 1) {
            return ResultMap.success(null);
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultMap login(String username, String password) {
        if (userService.login(username, password) != null) {
            return ResultMap.success(userService.login(username, password));
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "修改用户头像", notes = "修改用户头像")
    @RequestMapping(value = "/avatarUpdate", method = RequestMethod.POST)
    public ResultMap avatarUpdate(@RequestParam("file") MultipartFile file, Integer id,
                                  HttpServletRequest request) throws IOException {
        String url = FileUploadUtils.upLoadPicture(file, "upload/image", request);
        if (userService.updateAvatar(url, id) == 1) {
            return ResultMap.success(url);
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ResultMap UpdateUser(String username, String pwd, Integer id) {
        if (userService.updateUserInfo(username, pwd, id) == 1) {
            return ResultMap.success(null);
        }
        return ResultMap.fail(null);
    }
}
