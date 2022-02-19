package com.zgd.service;

import com.zgd.entity.Loginperson;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

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


}
