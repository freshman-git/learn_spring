package com.example.mybatisplus.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@TableName("user")
public class User {

    @TableId
    private Long id;

    private String name;

    private Integer age;

    private String email;


}
