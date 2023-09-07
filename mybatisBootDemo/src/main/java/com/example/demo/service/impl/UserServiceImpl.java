package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> getUser(String username, String password) {
        User user = userMapper.getUser(username,password);
        if (user!=null){
            UUID uuid = UUID.randomUUID();
//            user:04f6a27a-2526-4dbf-853d-235c7a5e0375
            String key = "user:"+uuid;
            HashMap<String, Object> map = new HashMap<>();
            map.put("token",key);
            map.put("user",user);
//          存入redis
            user.setPassword(null);
            redisTemplate.opsForValue().set(key,user,30, TimeUnit.MINUTES);

//            返回数据
            return map;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        Object obj = redisTemplate.opsForValue().get(token);
//        System.out.println("========="+obj);
        if (obj!=null){
            User curUser = JSON.parseObject(JSON.toJSONString(obj), User.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("name",curUser.getUsername());
            map.put("age",curUser.getAge());
            return map;
        }

        return null;
    }

    @Override
    public void logout(String token) {
        Boolean delete = redisTemplate.delete(token);
        log.info("==========="+delete);
    }

    @Override
    public Map<String, Object> getAllUser() {

        List<User> userList = userMapper.getAllUser();
        if (userList.size()>0){
            HashMap<String, Object> map = new HashMap<>();
            map.put("userList",userList);
            return map;
        }
        return null;
    }
}
