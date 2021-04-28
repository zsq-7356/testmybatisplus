package com.zsq.testmybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespnoseBean {
    private long code;
    private String message;
    private Object data;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RespnoseBean success(String message){
        return  new RespnoseBean(200,message,null);
    }

    /**
     * 成功返回结果
     * @param message
     * @param data
     * @return
     */
    public static RespnoseBean success(String message,Object data){
        return  new RespnoseBean(200,message,data);
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static RespnoseBean error(String message){
        return  new RespnoseBean(500,message,null);
    }

    /***
     * 失败返回结果
     * @param message
     * @param data
     * @return
     */
    public static RespnoseBean error(String message,Object data){
        return  new RespnoseBean(500,message,data);
    }
}
