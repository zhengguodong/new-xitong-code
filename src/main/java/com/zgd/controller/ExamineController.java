package com.zgd.controller;


import com.zgd.entity.Examine;
import com.zgd.service.ExamineService;
import com.zgd.utils.result;
import com.zgd.vo.addexamine;
import com.zgd.vo.editexamine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-02-19
 */
@RestController

public class ExamineController {
    @Resource
    private ExamineService examineService;
//    考核新增
@PostMapping("/addChecK")
    public Object addChecK(@RequestBody addexamine add){
    Examine ex=new Examine();
    ex.setName(add.getName());
    ex.setTitle(add.getTitle());
    ex.setDate(add.getDate());
    ex.setTeacher(add.getTeacher());
    ex.setStatus(add.getStatus());
    ex.setStatusAnswer(add.getStatus_answer());
    boolean flag=examineService.insertExamine(ex);
    if(flag){
        return result.success();
    }else{
        return result.fail();
    }

}
//考核编辑
    @PostMapping("/editCheck")
    public Object editCheck(@RequestBody Examine edit){

        boolean flag=examineService.editExamine(edit);
        if(flag){
            return result.success();
        }else{
            return result.fail();
        }
    }
//    改变状态 status
    @PostMapping("/changeCheck")
    public Object changeCheck(@RequestBody Map<String,Integer> map){
        Integer id=map.get("id");
        boolean flag=examineService.changeStatus(id);
        if(flag){
            return result.success();
        }else{
            return result.fail();
        }
    }
// 考核查询
    @PostMapping("/sCheck")
    public Object select(@RequestBody Map<String,Object> map){
        List<Examine> lists=examineService.selectLists(map.get("teacher").toString());
        return lists;

    }
//    分页
    @PostMapping("/checkpage")
    public Object checkpage(@RequestBody Map<String,Integer> map){
        return examineService.pagelist(map.get("pageNo"),map.get("pageCount"));

    }
    //获取单个数据
    @PostMapping("/getOne")
    public Object getone(@RequestBody Map<String,Integer> map){
    return examineService.getPerson(map.get("id"));

    }
//    改2
    @PostMapping("/changeStatus")
    public Object ff(@RequestBody Map<String,Integer> map){
        boolean flag=examineService.pushExamine(map.get("id"));
        if(flag){
            return result.success();
        }else{
            return result.fail();
        }
    }
}

