package com.example.demo.controller;


import com.example.demo.service.FlowerService;
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
@RequestMapping(value = "flower")
@Api(value = "花卉相关接口", description = "花卉相关接口")
public class FlowerController {
    @Resource
    private FlowerService flowerService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "发布接口", notes = "发布接口")
    public ResultMap publish(String name, String description, String id, @RequestParam("file") MultipartFile avatar, HttpServletRequest request) throws IOException {
        String url = FileUploadUtils.upLoadPicture(avatar, "upload/info", request);
        if (flowerService.publish( name, description, url,id) == 1) {
            return ResultMap.success(null);
        }
        return ResultMap.fail(null);
    }


    @RequestMapping(value = "getInfoByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页获取所有", notes = "分页获取所有")
    public ResultMap getInfoByPage(Integer offset, Integer pageSize) {
        if (flowerService.getByPage(offset, pageSize) != null) {
            return ResultMap.success(flowerService.getByPage(offset, pageSize));
        }
        return ResultMap.fail(null);
    }


    @RequestMapping(value = "getInfoCount", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有资讯的数量", notes = "获取所有资讯的数量")
    public ResultMap getCount() {
        if (flowerService.getCount() != null) {
            return ResultMap.success(flowerService.getCount());
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "deleteInfoById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id删除资讯", notes = "通过Id删除资讯")
    public ResultMap deleteInfoById(String id) {
        if (flowerService.deleteById(id) == 1) {
            return ResultMap.success(null);
        }
        return ResultMap.fail(null);
    }


    @RequestMapping(value = "getCollectionById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id查询资讯", notes = "通过Id查询资讯")
    public ResultMap getById(String id) {
        if (flowerService.getById(id) != null) {
            return ResultMap.success(flowerService.getById(id));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "updateInfo", method = RequestMethod.POST)
    @ApiOperation(value = "通过id更新资讯信息", notes = "通过id更新资讯信息")
    public ResultMap updateInfo(String name, String description, String id, @RequestParam("file") MultipartFile avatar, HttpServletRequest request) throws IOException {
        String url = FileUploadUtils.upLoadPicture(avatar, "upload/info", request);
        if (flowerService.updateInfo(name, description, url, id) == 1) {
            return ResultMap.success(null);
        }
        return ResultMap.fail(null);
    }
}
