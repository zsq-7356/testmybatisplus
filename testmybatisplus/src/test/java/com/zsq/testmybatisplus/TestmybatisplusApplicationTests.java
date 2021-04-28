package com.zsq.testmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsq.testmybatisplus.entity.Article;
import com.zsq.testmybatisplus.entity.User;
import com.zsq.testmybatisplus.mapper.ArticleMapper;
import com.zsq.testmybatisplus.mapper.CategoryMapper;
import com.zsq.testmybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TestmybatisplusApplicationTests {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    protected ArticleMapper articleMapper;

    @Autowired
    protected CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test1()
    {
       // userMapper.selectList(null);
        QueryWrapper wrapper=new QueryWrapper();

        //wrapper.eq("username","xiaoli");
        //userMapper.selectList(wrapper);
        //多条件
       /* HashMap<String,Object> map=new HashMap<>();
        map.put("username","xiaoli");
        map.put("age",20);//map 等值判断
        wrapper.allEq(map);*///wrapper 可以逻辑判断
       //wrapper.gt("age",18);
      //  wrapper.like("username","a");

        //inSql
        userMapper.selectList(wrapper);

    }

    @Test
    void test2(){
       // userMapper.selectById(1);
       // userMapper.selectBatchIds(Arrays.asList(1,2,3));

        QueryWrapper wrapper=new QueryWrapper();
        wrapper.gt("id",1);
        userMapper.selectCount(wrapper);
    }

    @Test
    void testPage(){

        Page<User> page =new Page<>(2,1);
        QueryWrapper wrapper=new QueryWrapper();
        //wrapper.gt("id",1);
        //Page<User> result= userMapper.selectPage(page,wrapper);
        Page<User> result= userMapper.selectPage(page,null);
        System.out.println("当前页 "+result.getCurrent());
        System.out.println("总记录数 "+result.getTotal());
        System.out.println("总页数 "+result.getPages());
        result.getRecords().forEach(System.out::println);
    }

    @Test
    void test3()
    {
        //userMapper.userList().forEach(System.out::println);
        /*for (User user :userMapper.userList())
        {
            System.out.println(user.getId()+"--"+user.getUsername());
        }

        for (User user :userMapper.userList()) {
            System.out.println(user.getId()+"--"+user.getUsername());
        }*/

        userMapper.userList().forEach(System.out::println);
    }

    @Test
    void  test_update(){
        User user=new User();
        user.setId(15);
        user.setAge(10);
        user.setUsername("aaaa");
        System.out.println(userMapper.updateById(user));
    }

    @Test
    void  test_insert(){
        User user=new User();
        user.setAge(18);
        user.setUsername("18gege");
        user.setPassword("password");

        System.out.println("状态是"+userMapper.insert(user));
    }

    @Test
    void  test_delete(){
        User user=new User();
        user.setId(17);

        //根据id删除
        //System.out.println("状态是"+userMapper.deleteById(17));

        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("id",16);
        System.out.println("状态是"+userMapper.delete(wrapper));
    }

    @Test
    void test_article()
    {
        //articleMapper.selectList(null).forEach(System.out::println);
        articleMapper.getArticleList().forEach(System.out::println);
        /*for (Article article: articleMapper.getArticleList() ) {
            System.out.println("id 是 "+article.getId());
            //System.out.println("标题 是 "+article.getTitle());
            //System.out.println("分类id 是 "+article.getCategory());
            //System.out.println("分类名称 是 "+article.getCname());
        }*/
    }

    @Test
    void test_article2()
    {
        articleMapper.selectList(null).forEach(System.out::println);

    }

    @Test
    void test_article3()
    {
        QueryWrapper<Article> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",10);
        articleMapper.selectOne(queryWrapper);

    }
    @Test
    void test_article4()
    {

        //articleMapper.getArticleList2().forEach(System.out::println);
        //articleMapper.getArticleList().forEach(System.out::println);
        for (Article article:articleMapper.getArticleList2()) {
            System.out.println("id "+article.getId()+"title "+article.getTitle()+"cname "+article.getCategory().getCname()+"cid"+article.getCategory().getCid());
        }

    }
    @Test
    void test_article54()
    {

        articleMapper.getArticleList().forEach(System.out::println);

    }
    @Test
    void test_Category()
    {
        //System.out.println( categoryMapper.getCategoryById(3));
        categoryMapper.getCategoryById(3);
        //categoryMapper.selectList(null).forEach(System.out::println);

    }


}
