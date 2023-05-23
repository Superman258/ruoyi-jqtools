package com.ruoyi.demo.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.demo.domain.TblZongjq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TblZongqjDto{

    /** 管辖单位 */
    @Excel(name = "管辖单位")
    @ApiModelProperty("管辖单位")
    private String gxAddress;

    /** 时期 */
    //@Excel(name = "时期")
    @ApiModelProperty("时期")
    private String time;

    @ApiModelProperty("统计各类别数量")
    private int tCt;
}
