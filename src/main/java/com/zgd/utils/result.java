package com.zgd.utils;

import com.zgd.entity.Result;

public class result {

    public static Result success(Object obj){
           Result r=new Result();
           r.setCode(200);
           r.setMsg("操作成功！");
           r.setData(obj);
           return r;
    }
    public static Result success(){
        Result r=new Result();
        r.setCode(200);
        r.setMsg("操作成功！");
        return r;
    }

    public static Result fail(){
        Result r=new Result();
        r.setCode(400);
        r.setMsg("操作失败！");
        return r;
    }
    public static Result fail(Integer code,String msg){
        Result r=new Result();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
