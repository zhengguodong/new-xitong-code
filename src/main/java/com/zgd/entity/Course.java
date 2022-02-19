package com.zgd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2022-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("course")
@ApiModel(value="Course对象", description="")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id 主键")
    @TableId(value = "courseid", type = IdType.AUTO)
    private Integer courseid;

    @ApiModelProperty(value = "课程创建的日期")
    private String date;

    @ApiModelProperty(value = "老师")
    private String teacher;

    @ApiModelProperty(value = "上课的时间")
    private String time;

    @ApiModelProperty(value = "学习内容")
    private String study;

    @ApiModelProperty(value = "课程类型")
    private String type;

    @ApiModelProperty(value = "上课地址")
    private String address;

    @ApiModelProperty(value = "课程名称")
    private String material;

    private String video;


}
