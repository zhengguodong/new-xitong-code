package com.zgd.controller;

import com.zgd.entity.Loginperson;
import com.zgd.service.LoginpersonService;
import com.zgd.utils.result;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UpdatetxController {
    @Resource
    private LoginpersonService loginpersonService;
    //    上传头像
    @PostMapping("/upadte11")
    public Object updatetx(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id") int id) throws IOException {
        if(avatorFile.isEmpty()){
            return result.fail();
        }
//        删除本地旧头像
        Loginperson p =loginpersonService.getById(id);
        String deleteFilePath=System.getProperty("user.dir")+p.getName();
        File deleteFile=new File(deleteFilePath);
        if(deleteFile.exists()){
            deleteFile.delete();
        }
//        定义上传文件名字为 时间+文件原名
        String fileName=System.currentTimeMillis()+avatorFile.getOriginalFilename();
//        获取jar包同级目录
//        定义上传文件路径  项目路径/img/avatorImages
        String filePath=System.getProperty("user.dir")+"/"+"img"+"/"+"avatorImages";
        File file1=new File(filePath);
//        检查是否存在filePath文件夹，不存在就创建一个
        if(!file1.exists()){
            file1.mkdir();
        }
//        目的地路径和生成文件名 项目路径/img/avatorImages+fileName
        File dest=new File(filePath+System.getProperty("file.separator")+fileName);
//        定义返回数据库的用户头像地址
        String storeAvatorPath="/img/avatorImages/"+fileName;
        try{
            avatorFile.transferTo(dest);
            Loginperson person=new Loginperson();
            person.setId(id);
            person.setName(storeAvatorPath);
            boolean res=loginpersonService.updateUserAvator(id,storeAvatorPath);
            if(res){
                return result.success(storeAvatorPath);
            }else{
                return result.fail();
            }
        }catch (IOException e){
            return result.fail();
        }

    }


}
