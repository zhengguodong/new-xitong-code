package com.zgd.mapper;

import com.zgd.entity.Homework;
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
public interface HomeworkMapper extends BaseMapper<Homework> {
    int updateStatus(@Param("courseid") Integer courseid);

}
