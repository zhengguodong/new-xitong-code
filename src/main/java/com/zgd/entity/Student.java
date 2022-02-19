package com.zgd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("student")
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Sno")
    private String sno;

    @TableField("Sname")
    private String sname;

    @TableField("Ssex")
    private String ssex;

    @TableField("Sage")
    private String sage;

    @TableField("Sdept")
    private String sdept;


}
