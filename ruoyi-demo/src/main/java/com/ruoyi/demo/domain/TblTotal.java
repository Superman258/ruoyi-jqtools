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
 * 总表对象 tbl_total
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_total")
@ApiModel("总表")
public class TblTotal extends BaseEntity
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

    /** 时期 */
    @Excel(name = "时期")
    @ApiModelProperty("时期")
    private String time;

    /** 总数 */
    @Excel(name = "总数")
    @ApiModelProperty("总数")
    private Integer zongshuNum;

    /** 刑事 */
    @Excel(name = "刑事")
    @ApiModelProperty("刑事")
    private Integer xingshiNum;

    /** 治安 */
    @Excel(name = "治安")
    @ApiModelProperty("治安")
    private Integer zhianNum;

    /** 交通 */
    @Excel(name = "交通事故")
    @ApiModelProperty("交通")
    private Integer jiaotongNum;

    /** 火灾 */
    @Excel(name = "火灾事故")
    @ApiModelProperty("火灾")
    private Integer huozaiNum;

    /** 求助 */
    @Excel(name = "求助")
    @ApiModelProperty("求助")
    private Integer qiuzhuNum;

    /** 咨询 */
    @Excel(name = "咨询")
    @ApiModelProperty("咨询")
    private Integer zixunNum;

    /** 举报 */
    @Excel(name = "举报")
    @ApiModelProperty("举报")
    private Integer jubaoNum;

    /** 投诉 */
    @Excel(name = "投诉监督")
    @ApiModelProperty("投诉")
    private Integer tousuNum;

    /** 事件 */
    @Excel(name = "事件")
    @ApiModelProperty("事件")
    private Integer shijianNum;

    /** 灾害 */
    @Excel(name = "灾害事故")
    @ApiModelProperty("灾害")
    private Integer zaihaiNum;

    /** 纠纷 */
    @Excel(name = "纠纷")
    @ApiModelProperty("纠纷")
    private Integer jiefenNum;

    /** 医疗 */
    @Excel(name = "医疗救助")
    @ApiModelProperty("医疗")
    private Integer yiliaoNum;

    /** 警务协助 */
    @Excel(name = "警务协助")
    @ApiModelProperty("警务协助")
    private Integer jingwuNum;

    /** 其他报警 */
    @Excel(name = "其他报警")
    @ApiModelProperty("其他报警")
    private Integer other;

    /** 未填 */
    @Excel(name = "未填")
    @ApiModelProperty("未填")
    private Integer weitian;

}
