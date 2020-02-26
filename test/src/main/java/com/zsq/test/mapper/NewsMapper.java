package com.zsq.test.mapper;

import com.zsq.test.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
public interface NewsMapper {

    @Select("select * from news where id=10")
    public News GetNewsList();
}
