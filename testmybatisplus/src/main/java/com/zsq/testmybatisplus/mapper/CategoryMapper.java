package com.zsq.testmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsq.testmybatisplus.entity.Category;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper extends BaseMapper<Category> {

    /*@Select("select * from category where cid=#{cid}")
    CategoryMapper getCategoryById(int cid);*/

    @Select("select * from category where cid=#{cid}")
    Category getCategoryById(int cid);
}
