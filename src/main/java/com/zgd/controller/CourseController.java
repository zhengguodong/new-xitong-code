package com.zgd.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Course;
import com.zgd.entity.Homework;
import com.zgd.entity.Result;
import com.zgd.service.CourseService;
import com.zgd.service.HomeworkService;
import com.zgd.utils.result;
import com.zgd.vo.addCourse;
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
public class CourseController {
    @Resource
    private CourseService courseService;
    @Resource
    private HomeworkService homeworkService;
//    获取课程表
    @PostMapping("/getCourse")
    public Object getCourse(){
        List<Course> lists=courseService.selectLists();
        return result.success(lists);
    }
//    新增课程
    @PostMapping("/addCourse")
    public Object addCourse(@RequestBody addCourse course){
        String date=course.getDate();
        String teacher=course.getTeacher();
        String time=course.getTime();
        String study=course.getStudy();
        String type=course.getType();
        String address=course.getAddress();
        String material=course.getMaterial();
        Course data=new Course();
        data.setDate(date);
        data.setTeacher(teacher);
        data.setTime(time);
        data.setStudy(study);
        data.setType(type);
        data.setAddress(address);
        data.setMaterial(material);
        int num=courseService.insertCourse(data);
        if(num!=0){
            return result.success();
        }else{
            return result.fail();
        }

    }
//    编辑课程
    @PostMapping("/editCourse")
    public Object edit(@RequestBody Course course){
        boolean flag=courseService.editCourse(course);
        if(flag){
            return result.success();
        }else{
            return result.fail();
        }
    }
//    分页
    @PostMapping("/page")
    public Object pagecourse(@RequestBody Map<String,Object> map){
        Integer pageNo= Integer.parseInt(map.get("pageNo").toString());
        Integer pageCount=Integer.parseInt(map.get("pageCount").toString()) ;
        String value=map.get("value").toString();
        Page<Course> page=courseService.getPage(pageNo,pageCount,value);
        return page;
    }
//模糊查询
    @PostMapping("/dimCourse")
    public Object dim(@RequestBody Map<String,Object> map){
        return courseService.dimSelect(map.get("value").toString());
    }
    //    作业发布 video状态改变  ?有点问题
    @PostMapping("/addHome")
    public Object addHome(@RequestBody Homework homework){
        int id=homework.getCourseid();
        boolean flag=courseService.addHomework(id);
        int num=homeworkService.addHome(homework);
        if(flag&&num!=0){
            return result.success();
        }else{
            return result.fail();
        }
    }

}

