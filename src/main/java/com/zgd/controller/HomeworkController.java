package com.zgd.controller;


import com.zgd.service.HomeworkService;
import com.zgd.utils.result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
public class HomeworkController {
    @Resource
    private HomeworkService homeworkService;
//    查询（包括模糊查询）
    @PostMapping("/selectHomework")
    public Object dimselect(@RequestBody Map<String,Object> map){
        return homeworkService.selectLists(map.get("value").toString());
    }
//分页
    @PostMapping("/pageHomework")
    public Object pageHomework(@RequestBody Map<String,Integer> map){
        return homeworkService.pagelists(map.get("pageNo"),map.get("pageCount"));
    }
//    作业提交 status状态改变
    @PostMapping("/submitHomework")
    public Object submit(@RequestBody Map<String,Integer> map){
        int id=map.get("courseid");
        boolean flag=homeworkService.submitHomework(id);
        if(flag){
            return result.success();
        }else{
            return result.fail();
        }
    }
//    查询作业表
    @PostMapping("/getHomework")
    public Object getData(){
        return homeworkService.list();
    }

}

