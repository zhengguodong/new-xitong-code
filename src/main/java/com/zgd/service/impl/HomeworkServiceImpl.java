package com.zgd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Homework;
import com.zgd.mapper.HomeworkMapper;
import com.zgd.service.HomeworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
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
public class HomeworkServiceImpl extends ServiceImpl<HomeworkMapper, Homework> implements HomeworkService {
    @Resource
    private HomeworkMapper homeworkMapper;
    @Override
    public List<Homework> selectLists(String value) {
        QueryWrapper<Homework> qw=new QueryWrapper<>();
        qw.like("material",value);
        return homeworkMapper.selectList(qw);
    }

    @Override
    public Page<Homework> pagelists(Integer pagNo, Integer pageCount) {
        Page<Homework> page=new Page<>(pagNo,pageCount);
        return homeworkMapper.selectPage(page,null);

    }

    @Override
    public boolean submitHomework(Integer courseid) {

        boolean flag=homeworkMapper.updateStatus(courseid)==0?false:true;
        return flag;
    }

    @Override
    public int addHome(Homework homework) {
        int num=homeworkMapper.insert(homework);
        return num;
    }
}
