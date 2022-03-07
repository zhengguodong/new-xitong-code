package com.zgd.service;

import com.zgd.entity.Loginperson;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgd.vo.Register;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-19
 */
@Service
public interface LoginpersonService extends IService<Loginperson> {
    Integer selectService(String username,String password);
    Integer register(Loginperson person);
    List<Loginperson> selectLists();

}
