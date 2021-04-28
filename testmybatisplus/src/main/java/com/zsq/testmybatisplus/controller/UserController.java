package com.zsq.testmybatisplus.controller;

import com.zsq.testmybatisplus.entity.RespnoseBean;
import com.zsq.testmybatisplus.entity.User;
import com.zsq.testmybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @GetMapping("/userList")
    public List<User> getList(Model model)
    {
        return userMapper.selectList(null);

    }

    @GetMapping("/userList2")
    public String getList2(Model model)
    {
       // return userMapper.selectList(null);
        Collection<User> userlist=userMapper.selectList(null);
        model.addAttribute("userList",userlist);
        return "List";
    }

    @GetMapping("/userList3")
    public RespnoseBean getList3(Model model)
    {
        return RespnoseBean.success("成功",userMapper.userList());
    }
    @PostMapping("/UserInsert")
    public RespnoseBean insert()
    {
        User user=new User();
        user.setId(20);
        user.setAge(18);
        user.setUsername("testusername");
        user.setPassword("88888");
        if(userMapper.insert(user)==1) {
            return RespnoseBean.success("添加成功", null);
        }
        else {
            return RespnoseBean.error("添加失败",null);
        }
    }

    @PutMapping("/UserUpdate")
    public RespnoseBean update()
    {
        User user=new User();
        user.setId(21);
        user.setAge(28);
        user.setUsername("testusername00");
        user.setPassword("88888---");
        if(userMapper.updateById(user)==1) {
            return RespnoseBean.success("修改成功", null);
        }
        else {
            return RespnoseBean.error("修改失败",null);
        }
    }

    @DeleteMapping("/UserDelete")
    public RespnoseBean delete()
    {
        /*User user=new User();
        user.setId(21);
        user.setAge(28);
        user.setUsername("testusername00");
        user.setPassword("88888---");*/
        if(userMapper.deleteById(20)==1) {
            return RespnoseBean.success("删除成功", null);
        }
        else {
            return RespnoseBean.error("删除失败",null);
        }
    }


}
