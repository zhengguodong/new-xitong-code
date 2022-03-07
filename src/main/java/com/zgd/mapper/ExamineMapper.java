package com.zgd.mapper;

import com.zgd.entity.Examine;
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
public interface ExamineMapper extends BaseMapper<Examine> {
    int updateStatus(@Param("id") Integer id);
    int updateSta(@Param("id") Integer id);
}
