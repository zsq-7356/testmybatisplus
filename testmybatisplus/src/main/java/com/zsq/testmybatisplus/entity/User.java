package com.zsq.testmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.ibatis.annotations.Lang;

@Data
public class User {
    @TableId
    private int id;
    private String username;
    private Integer age;
    private String password;
}
