package com.zgd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zgd.entity.Loginperson;
import com.zgd.mapper.LoginpersonMapper;
import com.zgd.service.LoginpersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgd.vo.Register;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginpersonServiceImpl extends ServiceImpl<LoginpersonMapper, Loginperson> implements LoginpersonService {
    @Resource
    private LoginpersonMapper loginpersonMapper;
    @Override
    public Integer selectService(String username, String password) {
        QueryWrapper<Loginperson> qw=new QueryWrapper<>();
        qw.eq("username",username);
        qw.eq("password",password);
        Integer num=loginpersonMapper.selectCount(qw);
        return num;
    }

    @Override
    public Integer register(Loginperson person) {
        QueryWrapper<Loginperson> qw=new QueryWrapper<>();

        List<Loginperson> lists=loginpersonMapper.selectList(qw);
        for(Loginperson l:lists){
            if(l.getUsername().equals(person.getUsername())){
                return 2;
            }
        }
        int num= loginpersonMapper.insert(person);
        return num;
    }

    @Override
    public List<Loginperson> selectLists() {
        QueryWrapper<Loginperson> qw=new QueryWrapper<>();

        List<Loginperson> list=loginpersonMapper.selectList(qw);
        return list;
    }

    @Override
    public boolean updateUserAvator(Integer id, String file) {
        Loginperson p=new Loginperson();
        p.setName(file);
        p.setId(id);
        QueryWrapper<Loginperson> qw=new QueryWrapper<>();
        qw.eq("id",id);
        return loginpersonMapper.update(p,qw)!=0?true:false;
    }
}
