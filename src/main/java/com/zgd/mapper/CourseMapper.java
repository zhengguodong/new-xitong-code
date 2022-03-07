package com.zgd.mapper;

import com.zgd.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2022-02-19
 */
public interface CourseMapper extends BaseMapper<Course> {
    int updateVideo(@Param("courseid") Integer courseid);
}
