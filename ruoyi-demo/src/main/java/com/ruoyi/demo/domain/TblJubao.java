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
@TableName("tbl_jubao")
@ApiModel("举报表")
public class TblJubao implements Serializable {
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

    /** 涉黄 */
    @Excel(name = "涉黄类")
    @ApiModelProperty("涉黄")
    private Integer shehuangNum;

    /** 涉赌 */
    @Excel(name = "涉赌类")
    @ApiModelProperty("涉赌")
    private Integer ganmbleNum;

    /** 涉毒 */
    @Excel(name = "涉毒类")
    @ApiModelProperty("涉毒")
    private Integer poisonNum;

    /** 假币 */
    @Excel(name = "假币类")
    @ApiModelProperty("假币")
    private Integer fakeMoney;

    /** 诈骗 */
    @Excel(name = "诈骗类")
    @ApiModelProperty("诈骗")
    private Integer cheatNum;

    /** 邪教 */
    @Excel(name = "法轮功等邪教类")
    @ApiModelProperty("邪教")
    private Integer heresyNum;

    /** 传销 */
    @Excel(name = "传销类")
    @ApiModelProperty("传销")
    private Integer chuanxiaoNum;

    /** 环境污染 */
    @Excel(name = "环境污染类")
    @ApiModelProperty("环境污染")
    private Integer huanjingNum;

    /** 食品药品 */
    @Excel(name = "食品药品类")
    @ApiModelProperty("食品药品")
    private Integer eatmedicaNum;

    /** 可疑人员 */
    @Excel(name = "可疑人员")
    @ApiModelProperty("可疑人员")
    private Integer dobiousPer;

    /** 可疑物品 */
    @Excel(name = "可疑物品")
    @ApiModelProperty("可疑物品")
    private Integer doubiousTh;

    /** 其他报备 */
    @Excel(name = "其他举报")
    @ApiModelProperty("其他报备")
    private Integer other;

    /** 未填 */
    @Excel(name = "未填")
    @ApiModelProperty("未填")
    private Integer weitian;
}
