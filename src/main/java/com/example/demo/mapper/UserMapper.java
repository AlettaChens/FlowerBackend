package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    @Insert("insert into f_user(nickName,pwd)values(#{nickName},#{pwd})")
    int register(@Param(value = "nickName") String nickName, @Param(value = "pwd") String pwd);

    @Select("select * from f_user where nickName=#{nickName}and pwd=#{pwd}")
    User login(@Param(value = "nickName") String nickName, @Param(value = "pwd") String pwd);

    @Update("update f_user set avatarUrl =#{avatar} where id=#{id}")
    int updateAvatar(@Param(value = "avatar") String avatar, @Param(value = "id") Integer id);

    @Update("update f_user set nickName=#{nickName},pwd=#{pwd}where id=#{id}")
    int updateUserInfo(@Param(value = "nickName") String nickName, @Param(value = "pwd") String pwd, @Param(value = "id") Integer id);
}
