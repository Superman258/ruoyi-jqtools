package com.ruoyi.demo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 总警情对象 tbl_zongjq
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_zongjq")
@ApiModel("总警情")
public class TblZongjq extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id")
    @ApiModelProperty("id")
    private Long id;

    /** 接警单警情类型 */
    @Excel(name = "接警单警情类型")
    @ApiModelProperty("接警单警情类型")
    private String type;

    /** 时期 */
    //@Excel(name = "时期")
    @ApiModelProperty("时期")
    private String time;

    /** 管辖单位 */
    @Excel(name = "管辖单位")
    @ApiModelProperty("管辖单位")
    private String gxAddress;

    /** 接警单警情类别 */
    @Excel(name = "接警单警情类别")
    @ApiModelProperty("接警单警情类别")
    private String jjdType;

    /** 处警单位 */
    @Excel(name = "处警单位")
    @ApiModelProperty("处警单位")
    private String cjAddress;

}
