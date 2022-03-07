package com.zgd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Course;
import com.zgd.mapper.CourseMapper;
import com.zgd.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-19
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Override
    public List<Course> selectLists() {
        QueryWrapper<Course> qw=new QueryWrapper<>();
        List<Course> lists=courseMapper.selectList(qw);
        return lists;
    }

    @Override
    public Integer insertCourse(Course course) {
        int num=courseMapper.insert(course);
        return num;
    }

    @Override
    public boolean editCourse(Course course) {
        int flag=courseMapper.updateById(course);
        if(flag!=0){
            return true;
        }
        return false;
    }

    @Override
    public Page<Course> getPage(Integer pageNo, Integer pageCount,String value) {
        if(value==null){
            Page<Course> page=new Page<>(pageNo,pageCount);
            Page<Course> obj=courseMapper.selectPage(page,null);
            return obj;
        }else{
            QueryWrapper<Course> qw=new QueryWrapper<>();
            qw.like("teacher",value);
            Page<Course> page=new Page<>(pageNo,pageCount);
            Page<Course> obj=courseMapper.selectPage(page,qw);
            return obj;
        }

    }

    @Override
    public List<Course> dimSelect(String value) {
        QueryWrapper<Course> qw=new QueryWrapper<>();
        qw.like("teacher",value);
        List<Course> lists=courseMapper.selectList(qw);
        return lists;
    }
    @Override
    public boolean addHomework(Integer courseid) {

        boolean flag=courseMapper.updateVideo(courseid)==0?false:true;
        return flag;
    }
}
