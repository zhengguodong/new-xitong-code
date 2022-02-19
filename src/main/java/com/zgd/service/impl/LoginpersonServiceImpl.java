package com.zgd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zgd.entity.Loginperson;
import com.zgd.mapper.LoginpersonMapper;
import com.zgd.service.LoginpersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


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
    @Autowired
    private LoginpersonMapper loginpersonMapper;
    @Override
    public Integer selectService(String username, String password) {
        QueryWrapper<Loginperson> qw=new QueryWrapper<>();
        qw.eq("usernamne",username);
        qw.eq("password",password);
        Integer num=loginpersonMapper.selectCount(qw);
        return num;
    }
}
