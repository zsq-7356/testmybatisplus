package com.zsq.test.controller;

import com.zsq.test.mapper.NewsMapper;
import com.zsq.test.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    NewsMapper newsMapper;


    @RequestMapping("/hello")
    public News sayhello()
    {
        /*News news=new News();
        news.setId(1);
        news.setTitle("abc");
        return "Hello-test00"+news.toString();*/


        return newsMapper.GetNewsList();
    }
}
