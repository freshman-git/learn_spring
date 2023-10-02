package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.DTO.UserDto;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Map<String, List<User>> getAllUser(UserDto userDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userDto.getId());
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
        HashMap<String, List<User>> map = new HashMap<>();
        map.put("res",users);
        return map;
    }
}
