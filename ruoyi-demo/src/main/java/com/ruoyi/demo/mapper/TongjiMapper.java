package com.ruoyi.demo.mapper;

import com.ruoyi.demo.domain.TblJubao;
import com.ruoyi.demo.domain.TblZongjq;
import com.ruoyi.demo.dto.TblZongqjDto;
import com.ruoyi.demo.dto.TotalCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface TongjiMapper {

    List<TotalCount> selectCtqcjq();
    List<TotalCount> selectCtqcjq1();

    List<TotalCount> selectDq();
//    List<TblJubao> selectDq1111();

    List<TotalCount> selectLq();

    List<TotalCount> selectQtzp();

    List<TotalCount> selectTxzp();

    List<TotalCount> selectDjdo();

    List<TotalCount> selectHd();

    List<TotalCount> selectSh();

    List<TotalCount> selectSd();


    List<TotalCount> selectzjjl();
    List<TblZongqjDto> selecall();
    List<TblZongqjDto> selectxszajf();
    List<TblZongqjDto> selectctqc();
    List<TotalCount> selecthd();
    List<TblZongqjDto> selecttxwl();
    List<TblZongqjDto> selectjf();
    List<TotalCount> selectjtsg();
    List<TotalCount> selecthzjq();
    List<TblZongqjDto> selectqz();


    void updatejb();
    void updatexs();
    void updateza();
    void updatetotal();

    void updategxadd();

}
