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
 * 治安对象 tbl_zhian
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_zhian")
@ApiModel("治安")
public class TblZhian implements Serializable
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

    /** 偷盗 */
    @Excel(name = "偷盗类")
    @ApiModelProperty("偷盗")
    private Integer toudaoNum;

    /** 抢劫 */
    @Excel(name = "抢劫")
    @ApiModelProperty("抢劫")
    private Integer qiangjieNum;

    /** 抢夺 */
    @Excel(name = "抢夺")
    @ApiModelProperty("抢夺")
    private Integer qiangduoNum;

    /** 网络诈骗 */
    @Excel(name = "通讯网络诈骗")
    @ApiModelProperty("网络诈骗")
    private Integer netcheatNum;

    /** 杀人 */
    @Excel(name = "杀人")
    @ApiModelProperty("杀人")
    private Integer killNum;

    /** 劫持 */
    @Excel(name = "劫持")
    @ApiModelProperty("劫持")
    private Integer jiechiNum;

    /** 爆炸 */
    @Excel(name = "爆炸")
    @ApiModelProperty("爆炸")
    private Integer explorNum;

    /** 抢劫 */
    @Excel(name = "强奸")
    @ApiModelProperty("强奸")
    private Integer rapeNum;

    /** 绑架 */
    @Excel(name = "绑架")
    @ApiModelProperty("绑架")
    private Integer bangjiaNum;

    /** 涉黄 */
    @Excel(name = "涉黄")
    @ApiModelProperty("涉黄")
    private Integer shehuangNum;

    /** 涉赌 */
    @Excel(name = "涉赌")
    @ApiModelProperty("涉赌")
    private Integer gambleNum;

    /** 涉毒 */
    @Excel(name = "涉毒")
    @ApiModelProperty("涉毒")
    private Integer poisonNum;

    /** 限制人身自由 */
    @Excel(name = "限制人身自由")
    @ApiModelProperty("限制人身自由")
    private Integer limitperNum;

    /** 妨碍公务 */
    @Excel(name = "妨碍公务")
    @ApiModelProperty("妨碍公务")
    private Integer gongwuNum;

    /** 敲诈勒索 */
    @Excel(name = "敲诈勒索")
    @ApiModelProperty("敲诈勒索")
    private Integer qiaozhaNum;

    /** 投毒 */
    @Excel(name = "投毒")
    @ApiModelProperty("投毒")
    private Integer touduNum;

    /** 伤害 */
    @Excel(name = "伤害")
    @ApiModelProperty("伤害")
    private Integer hertNum;

    /** 打架斗殴 */
    @Excel(name = "打架斗殴")
    @ApiModelProperty("打架斗殴")
    private Integer fightNum;

    /** 拐卖儿童 */
    @Excel(name = "拐卖妇女儿童")
    @ApiModelProperty("拐卖妇女儿童")
    private Integer guaimaiNum;

    /** 家庭暴力 */
    @Excel(name = "家庭暴力")
    @ApiModelProperty("家庭暴力")
    private Integer jiatingNum;

    /** 损坏财物 */
    @Excel(name = "损坏公私财物")
    @ApiModelProperty("损坏财物")
    private Integer sunhuaiNum;

    /** 传销 */
    @Excel(name = "传销")
    @ApiModelProperty("传销")
    private Integer chuaixiaoNum;

    /** 其他 */
    @Excel(name = "其他")
    @ApiModelProperty("其他")
    private Integer other;

    /** 其他诈骗 */
    @Excel(name = "其他诈骗")
    @ApiModelProperty("其他诈骗")
    private Integer othercheatNum;

    /** 未填 */
    @Excel(name = "未填")
    @ApiModelProperty("未填")
    private Integer weitianNum;

}
