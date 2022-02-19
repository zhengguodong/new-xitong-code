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
@TableName("examine")
@ApiModel(value="Examine对象", description="")
public class Examine implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生名称")
    private String name;

    @ApiModelProperty(value = "考核内容")
    private String title;

    @ApiModelProperty(value = "考核日期")
    private String date;

    @ApiModelProperty(value = "导师")
    private String teacher;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "编辑发布的状态")
    private String status;

    @ApiModelProperty(value = "答题内容")
    private String value;

    @ApiModelProperty(value = "评分的状态")
    private String statusAnswer;


}
