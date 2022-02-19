package com.zgd.controller;


import com.zgd.service.LoginpersonService;
import com.zgd.service.impl.LoginpersonServiceImpl;
import com.zgd.utils.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-02-19
 */
@RestController
@RequestMapping("/loginperson")
public class LoginpersonController {
    @Resource
    private LoginpersonService loginpersonService;
    @PostMapping("/login")
    public Object login(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        String password=map.get("password").toString();
        Integer num=loginpersonService.selectService(username,password);
        if(num==1){
            return result.success();
        }else if(num>1){
            return result.fail();
        }else {
            return result.fail();
        }
    }

}

