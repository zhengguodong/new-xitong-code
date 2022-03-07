package com.zgd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgd.entity.Reportcard;
import com.zgd.mapper.ReportcardMapper;
import com.zgd.service.ReportcardService;
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
public class ReportcardServiceImpl extends ServiceImpl<ReportcardMapper, Reportcard> implements ReportcardService {
    @Resource
    private ReportcardMapper reportcardMapper;
    @Override
    public List<Reportcard> selectLists(String name) {
        QueryWrapper<Reportcard> qw=new QueryWrapper<>();
        qw.like("name",name);
        qw.orderByDesc("grade");
        return reportcardMapper.selectList(qw);

    }

    @Override
    public boolean addScore(Reportcard reportcard) {

        return reportcardMapper.insert(reportcard)==0?false:true;
    }

    @Override
    public Page<Reportcard> pagelists(Integer pageNo,Integer pageCount,String name) {
        Page<Reportcard> pagelist=new Page<>(pageNo,pageCount);
        if(name==null){
            Page<Reportcard> lists=reportcardMapper.selectPage(pagelist,null);
            return lists;
        }else{
            QueryWrapper<Reportcard> qw=new QueryWrapper<>();
            qw.like("name",name);
            Page<Reportcard> lists=reportcardMapper.selectPage(pagelist,qw);
            return lists;
        }

    }
}
