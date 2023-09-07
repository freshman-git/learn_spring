package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

//    @Select("select id,username,password,age from user where id = #{id}")
    public User getUserById(int id);
}
