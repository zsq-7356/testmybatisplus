package com.zsq.testmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Article {
    private int id;
    private int cid;

    @TableField(exist = false)
    private Category category;

    @TableField(exist = false)//这是关联查询时用
    private String cname;
    private String title;
    private String content;
}
