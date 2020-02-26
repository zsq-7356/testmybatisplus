package com.zsq.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("getclass is "+dataSource.getClass());
        System.out.println("getConnection is "+dataSource.getConnection());//alt+enter 选择


        /*int i=jdbcTemplate.update("insert into News(classid,title) value (1,'title test3')");
        if(i>0){
            System.out.println("添加成功！");
        }*/

       /* int i=jdbcTemplate.update("update News set classid=2,title='title00000000' where id=11");
        if(i>0){
            System.out.println("修改成功！");
        }*/
       int i=jdbcTemplate.update("delete from news where id=11");
        if(i>0){
            System.out.println("删除成功！");
        }


        System.out.println(jdbcTemplate.queryForList("select * from News order by id desc"));

    }

}
