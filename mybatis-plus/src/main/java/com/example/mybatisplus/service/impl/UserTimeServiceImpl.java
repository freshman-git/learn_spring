package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.mapper.UserTimeMapper;
import com.example.mybatisplus.pojo.UserTime;
import com.example.mybatisplus.service.UserTimeService;
import org.springframework.stereotype.Service;

@Service
public class UserTimeServiceImpl extends ServiceImpl<UserTimeMapper, UserTime> implements UserTimeService {
}
