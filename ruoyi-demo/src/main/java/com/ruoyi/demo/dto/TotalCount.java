package com.ruoyi.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TotalCount {

    @ApiModelProperty("单位")
    private String address;

    @ApiModelProperty("时间")
    private String time;

    @ApiModelProperty("总数")
    private int total;
}
