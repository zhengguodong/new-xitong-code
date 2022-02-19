package com.zgd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("homework")
@ApiModel(value="Homework对象", description="")
public class Homework implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "courseid", type = IdType.AUTO)
    private Integer courseid;

    @ApiModelProperty(value = "开始时间")
    @TableField("startTime")
    private String starttime;

    @ApiModelProperty(value = "结束时间")
    @TableField("endTime")
    private String endtime;

    @ApiModelProperty(value = "作业内容")
    private String content;

    @ApiModelProperty(value = "导师")
    private String headman;

    @ApiModelProperty(value = "作业的提交状态")
    private String status;

    @ApiModelProperty(value = "课程名")
    private String material;

    @ApiModelProperty(value = "时间")
    private String date;


}
