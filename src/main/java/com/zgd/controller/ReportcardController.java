package com.zgd.controller;


import com.zgd.entity.Reportcard;
import com.zgd.service.ReportcardService;
import com.zgd.utils.result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

public class ReportcardController {
    @Resource
    private ReportcardService reportcardService;
//    获取成绩表(查询)
    @PostMapping("/getReportCard")
    public Object getReportCard(@RequestBody Map<String,Object> map){
        String name=map.get("name").toString();
        List<Reportcard> lists=reportcardService.selectLists(name);
        return lists;
    }
//  考核打分
    @PostMapping("/score")
    public Object getScore(@RequestBody Reportcard reportcard){
        boolean flag=reportcardService.addScore(reportcard);
        if(flag){
            return result.success();
        }else{
            return result.fail();
        }
    }
//    分页(加查询) 分页参照
    @PostMapping("/pageReportCard")
    public Object page(@RequestBody Map<String,Object> map){
        return reportcardService.pagelists(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageCount").toString()),map.get("name").toString());
    }
}

