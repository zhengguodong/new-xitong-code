package com.zgd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Examine;
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
public interface ExamineService extends IService<Examine> {
    boolean insertExamine(Examine examine);
    boolean editExamine(Examine examine);
    boolean changeStatus(Integer id);
    List<Examine> selectLists(String teacher);
    Page<Examine> pagelist(Integer pageNo,Integer PageCount);
    Examine getPerson(Integer id);
    boolean pushExamine(Integer id);
}
