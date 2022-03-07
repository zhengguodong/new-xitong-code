package com.zgd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Examine;
import com.zgd.mapper.ExamineMapper;
import com.zgd.service.ExamineService;
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
public class ExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements ExamineService {
    @Resource
    private ExamineMapper examineMapper;
    @Override
    public boolean insertExamine(Examine examine) {

        return examineMapper.insert(examine)==1?true:false;
    }

    @Override
    public boolean editExamine(Examine examine) {

        return examineMapper.updateById(examine)==0?false:true;
    }

    @Override
    public boolean changeStatus(Integer id) {

        return examineMapper.updateStatus(id)==0?false:true;
    }

    @Override
    public List<Examine> selectLists(String teacher) {
        QueryWrapper<Examine> qw=new QueryWrapper<>();
        qw.like("teacher",teacher);

        return examineMapper.selectList(qw);
    }

    @Override
    public Page<Examine> pagelist(Integer pageNo, Integer PageCount) {
        Page<Examine> pages=new Page<>(pageNo,PageCount);

        return examineMapper.selectPage(pages,null);
    }

    @Override
    public Examine getPerson(Integer id) {
        QueryWrapper<Examine> qw=new QueryWrapper<>();
        qw.eq("id",id);

        return examineMapper.selectOne(qw);
    }

    @Override
    public boolean pushExamine(Integer id) {

        return examineMapper.updateSta(id)==0?false:true;
    }
}
