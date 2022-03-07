package com.zgd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Homework;
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
public interface HomeworkService extends IService<Homework> {
        List<Homework> selectLists(String value);
        Page<Homework> pagelists(Integer pagNo,Integer pageCount);
        boolean submitHomework(Integer courseid);
        int addHome(Homework homework);

}
