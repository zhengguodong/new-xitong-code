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
@TableName("reportcard")
@ApiModel(value="Reportcard对象", description="")
public class Reportcard implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "成绩")
    private String grade;

    @ApiModelProperty(value = "日期")
    private String date;

    private String title;

    private String status;


}
