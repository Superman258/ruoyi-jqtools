package com.ruoyi.web.controller.demo;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.demo.domain.*;
import com.ruoyi.demo.dto.TblZongqjDto;
import com.ruoyi.demo.mapper.TblJubaoMapper;
import com.ruoyi.demo.mapper.TblTotalMapper;
import com.ruoyi.demo.mapper.TblXingshiMapper;
import com.ruoyi.demo.mapper.TblZhianMapper;
import com.ruoyi.demo.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "统计管理",tags = "统计管理")
@RestController
@RequestMapping("/demo/tongji")
@Component
@Slf4j
public class TongjiController {

    @Autowired
    private TongjiService tongjiService;

    @Resource
    private TblJubaoMapper tblJubaoMapper;

    @Resource
    private TblTotalMapper tblTotalMapper;

    @Resource
    private TblXingshiMapper tblXingshiMapper;

    @Resource
    private TblZhianMapper tblZhianMapper;

    /*有效警情*/
    @ApiOperation("计算有效警情同环比")
    @PostMapping("/jingqing")
    public AjaxResult list(TblTotal tblTotal) {
        List<TblCondition>  yxjqList = tongjiService.getYxjq();
        Map<String,List<TblCondition>> resultMap = new HashMap();
        resultMap.put("yxjqList",yxjqList);
        return AjaxResult.success(resultMap);
    }


    /*刑事治安 */
    @ApiOperation("计算刑事治安同环比")
    @PostMapping("/xingshi")
    public AjaxResult security(TblTotal tblTotal) {

        List<TblCondition>  xszaList = tongjiService.getXsza();

        List<TblCondition>  xsList = tongjiService.getXs();

        List<TblCondition>  zaList = tongjiService.getZa();

        Map<String,List<TblCondition>> resultMap = new HashMap();
        resultMap.put("xszaList",xszaList);
        resultMap.put("xsList",xsList);
        resultMap.put("zaList",zaList);
        return AjaxResult.success(resultMap);
    }

    /*纠纷*/
    @ApiOperation("计算纠纷同环比")
    @PostMapping("/jiufen")
    public AjaxResult dispute(TblTotal tblTotal) {
        List<TblCondition>  jfList = tongjiService.getJf();
        Map<String,List<TblCondition>> resultMap = new HashMap();
        resultMap.put("jfList",jfList);
        return AjaxResult.success(resultMap);
    }

    /*通讯网络诈骗 */
    @ApiOperation("计算通讯网络诈骗同环比")
    @PostMapping("/netcheat")
    public AjaxResult netcheat(TblXingshi tblXingshi, TblZhian tblZhian) {//刑事-网络诈骗+治安-网络诈骗
        List<TblCondition>  txzpList = tongjiService.getTxzp();
        Map<String,List<TblCondition>> resultMap = new HashMap();
        resultMap.put("txzpList",txzpList);
        return AjaxResult.success(resultMap);
    }


    /*传统侵财*/
    @ApiOperation("计算传统侵财同环比")
    @PostMapping("/attack")
    public AjaxResult attack(TblXingshi tblXingshi, TblZhian tblZhian) {
        //获取传统侵财警情
        List<TblCondition>  ctqcList = tongjiService.getCtqcqj();
        //盗窃警情
        List<TblCondition>  dqList = tongjiService.getDqqj();
        //两抢警情
        List<TblCondition>  lqList = tongjiService.getLqqj();
        //其他诈骗警情
        List<TblCondition>  qtzpList = tongjiService.getQtzpqj();
        Map<String,List<TblCondition>> resultMap = new HashMap();
        resultMap.put("ctqcList",ctqcList);
        resultMap.put("dqList",dqList);
        resultMap.put("lqList",lqList);
        resultMap.put("qtzpList",qtzpList);
        return AjaxResult.success(resultMap);
    }

    /*黄赌*/
    @ApiOperation("计算黄赌同环比")
    @PostMapping("/gamble")
    public AjaxResult gamble(TblXingshi tblXingshi, TblZhian tblZhian, TblJubao tblJubao) {
        //获取黄赌警情
        List<TblCondition>  hdList = tongjiService.gethd();
        //涉黄
        List<TblCondition>  shList = tongjiService.getsh();
        //涉赌
        List<TblCondition>  sdList = tongjiService.getsd();

        Map<String,List<TblCondition>> resultMap = new HashMap();
        resultMap.put("hdList",hdList);
        resultMap.put("shList",shList);
        resultMap.put("sdList",sdList);
        return AjaxResult.success(resultMap);
    }

    /*打架斗殴*/
    @ApiOperation("计算打架斗殴同环比")
    @PostMapping("/fight")
    public AjaxResult fight(TblXingshi tblXingshi, TblZhian tblZhian) {
        List<TblCondition>  djdoList = tongjiService.getDjdo();
        Map<String,List<TblCondition>> resultMap = new HashMap();
        resultMap.put("djdoList",djdoList);
        return AjaxResult.success(resultMap);
    }

    /*总警情表*/
    @PostMapping("/zjjl")
    public AjaxResult zjjl(){
        List<TblCondition>  ZjjlList = tongjiService.getzjjl();

        List<TblCondition> YxjqList= tongjiService.selecall();

        List<TblCondition> XszajfList= tongjiService.getxszjjf();

        List<TblCondition> CtqcList= tongjiService.getcxqc();

        List<TblCondition> HdjqList= tongjiService.gethdjq();

        List<TblCondition> TxwlList= tongjiService.gettxwl();

        List<TblCondition> JfList= tongjiService.getjf();

        List<TblCondition> JtsgList= tongjiService.getjtsg();

        List<TblCondition> HzjqList= tongjiService.gethzjq();

        List<TblCondition> QzList= tongjiService.getqz();


        Map<String,List<TblCondition>> resultMap = new HashMap();
        resultMap.put("xszaList",ZjjlList);
        resultMap.put("xsList",YxjqList);
        resultMap.put("XszajfList",XszajfList);
        resultMap.put("CtqcList",CtqcList);
        resultMap.put("HdjqList",HdjqList);
        resultMap.put("TxwlList",TxwlList);
        resultMap.put("JfList",JfList);
        resultMap.put("JtsgList",JtsgList);
        resultMap.put("HzjqList",HzjqList);
        resultMap.put("QzList",QzList);

        return AjaxResult.success(resultMap);
    }

    /*派出所加分*/
    @PostMapping("/pcsjq")
    public AjaxResult pcsjq() {
        //获取黄赌警情
        List<TblCondition>  xszaList = tongjiService.getXsza();

        List<TblCondition>  hdList = tongjiService.gethd();

        List<TblCondition>  ctqcList = tongjiService.getCtqcqj();

        Map<String,List<TblCondition>> resultMap = new HashMap();

        resultMap.put("xszaList",xszaList);

        resultMap.put("ctqcList",ctqcList);

        resultMap.put("hdList",hdList);

        return AjaxResult.success(resultMap);
    }

    @ApiOperation("删除全部表模板")
    @DeleteMapping("/clean")
    public void delete() {
        tblZhianMapper.truncateTable();
        tblXingshiMapper.truncateTable();
        tblTotalMapper.truncateTable();
        tblJubaoMapper.truncateTable();
    }

    @PostMapping("tjjb")
    public AjaxResult tjjb(){
        tongjiService.updategx();
        tongjiService.addjb();
        tongjiService.addxs();
        tongjiService.addza();
        tongjiService.addtotal();
        return AjaxResult.success("success");
    }
}
