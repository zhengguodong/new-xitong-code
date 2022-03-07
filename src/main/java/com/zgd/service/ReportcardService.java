package com.zgd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Reportcard;
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
public interface ReportcardService extends IService<Reportcard> {
    List<Reportcard> selectLists(String name);
    boolean addScore(Reportcard reportcard);
    Page<Reportcard> pagelists(Integer pageNo, Integer pageCount,String name);
}
