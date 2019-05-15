package com.example.demo.mapper;


import com.example.demo.entity.Count;
import com.example.demo.entity.Flower;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface FlowerMapper extends Mapper<Flower> {
    @Insert("insert into f_info(flowerId,flowerName,flowerInfo,flowerAvatarUrl)values(#{flowerId},#{flowerName},#{flowerInfo},#{flowerAvatarUrl})")
    int publish(@Param(value = "flowerId") String flowerId, @Param(value = "flowerName") String flowerName, @Param(value = "flowerInfo") String flowerInfo, @Param(value = "flowerAvatarUrl") String flowerAvatarUrl);

    @Select("select flowerName,count(flowerName) as flowerCount from f_info group by flowerName")
    List<Count> getCount();

    @Select("select * from f_info limit #{offset},#{pageSize}")
    List<Flower> getByPage(@Param(value = "offset") Integer offset, @Param(value = "pageSize") Integer pageSize);

    @Select("select * from f_info where flowerId=#{flowerId}")
    Flower getById(@Param(value = "flowerId") String flowerId);

    @Delete("delete from f_info where flowerId=#{flowerId}")
    int deleteById(@Param(value = "flowerId") String flowerId);

    @Update("update f_info set flowerName=#{flowerName},flowerInfo=#{flowerInfo},flowerAvatarUrl=#{flowerAvatarUrl}where flowerId=#{flowerId}")
    int updateInfo(@Param(value = "flowerName") String flowerName, @Param(value = "flowerInfo") String flowerInfo, @Param(value = "flowerAvatarUrl") String flowerAvatarUrl, @Param(value = "flowerId") String flowerId);

}
