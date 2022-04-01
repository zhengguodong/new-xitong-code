package com.zgd.controller;


import com.zgd.entity.Loginperson;
import com.zgd.service.LoginpersonService;
import com.zgd.service.impl.LoginpersonServiceImpl;
import com.zgd.util.jwtUtil;
import com.zgd.utils.result;
import com.zgd.vo.Register;
import com.zgd.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
public class LoginpersonController {
    @Resource
    private LoginpersonService loginpersonService;
    @PostMapping("/login")
    public Object login(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        String password=map.get("password").toString();
        Integer num=loginpersonService.selectService(username,password);
        String token= jwtUtil.createJwt();
        User user=new User();
        user.setToken(token);
        user.setUsername(username);
        if(num==1){
            return result.success(user);
        }else {
            return result.fail();
        }
    }
    @GetMapping("/checktoken")
    public Object checktoken(HttpServletRequest req){
        String token =req.getHeader("token");
        return jwtUtil.checkToken(token);
    }
    @PostMapping("/register")
    public Object register(@RequestBody Register re){
        String username=re.getUsername();
        String password=re.getPassword();
        String status=re.getStatus();
        Loginperson person=new Loginperson();
        person.setUsername(username);
        person.setPassword(password);
        person.setStatus(status);
        int num=loginpersonService.register(person);
        if(num==1){
            return result.success();
        }else if(num==2){
            return result.fail(300,"账号重复，请重新输入");
        }else{
            return result.fail();
        }
    }
//    获取用户表数据
    @PostMapping("/searchPerson")
    public Object search(){
        List<Loginperson> lists=loginpersonService.selectLists();
        return result.success(lists);
    }

}

