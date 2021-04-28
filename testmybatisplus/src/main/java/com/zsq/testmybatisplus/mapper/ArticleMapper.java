package com.zsq.testmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsq.testmybatisplus.entity.Article;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {

    /*@Select("select * from article order by id desc")
    List<Article> getArticleList();*/
    @Select("SELECT a.*,cat.cid FROM article as a LEFT JOIN category as cat on a.cid=cat.cid")
    List<Article> getArticleList();

    @Select("SELECT * from article")
    @Results(id = "ArticleList",value = {
            @Result(property = "category",column = "cid",one = @One(select = "com.zsq.testmybatisplus.mapper.CategoryMapper.getCategoryById",fetchType = FetchType.EAGER))
    })
    List<Article> getArticleList2();


}
