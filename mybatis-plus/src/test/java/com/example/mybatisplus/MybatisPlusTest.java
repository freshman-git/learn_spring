package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.DTO.UserDto;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.pojo.UserTime;
import com.example.mybatisplus.service.UserService;
import com.example.mybatisplus.service.UserTimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTimeService userTimeService;

    @Test
    public void testSelectList(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetUser(){
        UserDto userDto = new UserDto();
        userDto.setId(1);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userDto.getId());
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test(){
        QueryWrapper<UserTime> queryWrapper = new QueryWrapper<>();
        UserTime userTime = new UserTime();
//        LocalDateTime now = LocalDateTime.now();
//        Date date = new Date();
//        userTime.setCreateTime(date);
//        userTimeService.save(userTime);
//        System.out.println(userTime);
        queryWrapper.eq("id","1708316224632459265");
        UserTime one = userTimeService.getOne(queryWrapper);
        System.out.println(one);
//        userTimeService.save(userTime);
//        System.out.println(userTime.toString());
    }

    @Test
    public void testPage(){
        Page<User> userPage = new Page<>(1,3);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        userPage = userMapper.selectPage(userPage,null);
        System.out.println(userPage.getRecords());
    }
}
