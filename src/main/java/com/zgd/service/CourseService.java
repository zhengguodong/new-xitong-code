package com.zgd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-19
 */
public interface CourseService extends IService<Course> {
        List<Course> selectLists();
        Integer insertCourse(Course course);
        boolean editCourse(Course course);
        Page<Course> getPage(Integer pageNo,Integer pageCount,String value);
        List<Course> dimSelect(String value);
        boolean addHomework(Integer courseid);
}
