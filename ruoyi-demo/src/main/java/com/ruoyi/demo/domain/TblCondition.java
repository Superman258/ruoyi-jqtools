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
 * 举报表对象 tbl_jubao
 *
 * @author ruoyi
 * @date 2022-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_condition")
@ApiModel("环比同比情况表")
public class TblCondition
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id")
    @ApiModelProperty("id")
    private Long id;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String address;

    /** 本期 */
    @Excel(name = "本期")
    @ApiModelProperty("本期")
    private int benqiNum;

    /** 去年同期 */
    @Excel(name = "去年同期")
    @ApiModelProperty("去年同期")
    private int qunianNum;

    /** 同比 */
    @Excel(name = "同比")
    @ApiModelProperty("同比")
    private String tongbiNum;

    /** 上期 */
    @Excel(name = "上期")
    @ApiModelProperty("上期")
    private int shangqiNum;

    /** 环比 */
    @Excel(name = "环比")
    @ApiModelProperty("环比")
    private String huanbiNum;

    private Integer ordNum;



}
