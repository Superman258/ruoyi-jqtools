package com.ruoyi.demo.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.demo.domain.TblJubao;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TblZhianDto extends TblXingshiDto{
    private List<TblJubao> jubaos=new ArrayList<>();

    /** 本期 */
    @Excel(name = "本期")
    @ApiModelProperty("本期")
    private Integer benqiNum;

    /** 去年同期 */
    @Excel(name = "去年同期")
    @ApiModelProperty("去年同期")
    private Integer qunianNum;

    /** 同比 */
    @Excel(name = "同比")
    @ApiModelProperty("同比")
    private String tongbiNum;

    /** 上期 */
    @Excel(name = "上期")
    @ApiModelProperty("上期")
    private Integer shangqiNum;

    /** 环比 */
    @Excel(name = "环比")
    @ApiModelProperty("环比")
    private String huanbiNum;
}
