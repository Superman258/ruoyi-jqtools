package com.ruoyi.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.utils.ComputeUtils;
import com.ruoyi.demo.domain.*;
import com.ruoyi.demo.dto.TblZhianDto;
import com.ruoyi.demo.dto.TblZongqjDto;
import com.ruoyi.demo.dto.TotalCount;
import com.ruoyi.demo.mapper.*;
import com.ruoyi.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TongjiServiceImpl implements TongjiService {

    @Autowired
    private ITblJubaoService tblJubaoService;

    @Autowired
    private ITblTotalService tblTotalService;

    @Autowired
    private ITblXingshiService tblXingshiService;

    @Autowired
    private ITblZhianService tblZhianService;

    @Resource
    private TongjiMapper tongjiMapper;


    /**
     * 获取传统侵财警情
     *
     * @return
     */
    @Override
    public List<TblCondition> getCtqcqj() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        //查询传统侵财警情：（刑事-偷盗类+抢劫+抢夺+其他诈骗）+ （治安-偷盗类+抢劫+抢夺+其他诈骗）
        /*List<TblJubao> list=tongjiMapper.selectDq1111();
        int i= list.get(0).getGanmbleNum()+list.get(1).getGanmbleNum();*/

        List<TotalCount> totalCountList = tongjiMapper.selectCtqcjq();

        if (!totalCountList.isEmpty()) {

            //Stream 将List<对象>转换为Map<String,List<对象
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }

        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    /**
     * 盗窃警情
     *
     * @return
     */
    @Override
    public List<TblCondition> getDqqj() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        //查询传统侵财警情：（刑事-偷盗类）+ （治安-偷盗类）
        List<TotalCount> totalCountList = tongjiMapper.selectDq();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    /**
     * 两抢警情
     *
     * @return
     */
    @Override
    public List<TblCondition> getLqqj() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        //查询传统侵财警情：（刑事-偷盗类）+ （治安-偷盗类）
        List<TotalCount> totalCountList = tongjiMapper.selectLq();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }

        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    /**
     * 其他诈骗警情
     *
     * @return
     */
    @Override
    public List<TblCondition> getQtzpqj() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        //查询传统侵财警情：（刑事-偷盗类）+ （治安-偷盗类）
        List<TotalCount> totalCountList = tongjiMapper.selectQtzp();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }


    /**
     * 通信诈骗
     *
     * @return
     */
    @Override
    public List<TblCondition> getTxzp() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        //查询传统侵财警情：（刑事-偷盗类）+ （治安-偷盗类）
        List<TotalCount> totalCountList = tongjiMapper.selectTxzp();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }


    /**
     * 打架斗殴
     *
     * @return
     */
    @Override
    public List<TblCondition> getDjdo() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        //查询传统侵财警情：（刑事-偷盗类）+ （治安-偷盗类）
        List<TotalCount> totalCountList = tongjiMapper.selectDjdo();
        if (!totalCountList.isEmpty()) {
            //Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));
            Map<String, List<TotalCount>> listMap = totalCountList.stream().sorted(Comparator.comparing(TotalCount::getAddress).reversed()).collect(Collectors.groupingBy(TotalCount::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    @Override
    public List<TblCondition> gethd() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
//黄赌警情
        List<TotalCount> totalCountList = tongjiMapper.selectHd();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }

        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    @Override
    public List<TblCondition> getsh() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
//涉黄警情
        List<TotalCount> totalCountList = tongjiMapper.selectSh();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    @Override
    public List<TblCondition> getsd() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
//涉赌警情
        List<TotalCount> totalCountList = tongjiMapper.selectSd();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    @Override
    public List<TblCondition> getJf() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        QueryWrapper<TblTotal> queryWrapper = new QueryWrapper<>();//构建条件构造器
        //添加查询条件
        queryWrapper.select("id", "address", "time", "jiefen_num");
        queryWrapper.likeLeft("address", "所");
        queryWrapper.ne("address", "柯桥区万绣所");
        queryWrapper.or().eq("address", "柯桥区");
        queryWrapper.groupBy("address", "time");
        List<TblTotal> totalList = tblTotalService.list(queryWrapper);//查到的数据传入
        if (!totalList.isEmpty()) {//总表-纠纷
            Map<String, List<TblTotal>> listMap = totalList.stream().collect(Collectors.groupingBy(TblTotal::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数 总表-治安
                        tblCondition.setBenqiNum(item.getJiefenNum());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getJiefenNum());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getJiefenNum());
                    }
                });
                //计算刑事和治安警情同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算刑事和治安警情环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    @Override
    public List<TblCondition> getYxjq() {


        List<TblCondition> resultList = new ArrayList<TblCondition>();
        QueryWrapper<TblTotal> queryWrapper = new QueryWrapper<>();//构建条件构造器
        //添加查询条件
        queryWrapper.select("id", "address", "time", "zongshu_num");
        queryWrapper.likeLeft("address", "所");
        queryWrapper.ne("address", "柯桥区万绣所");
        queryWrapper.or().eq("address", "柯桥区");
        queryWrapper.groupBy("address", "time");


        List<TblTotal> totalList = tblTotalService.list(queryWrapper);//查到的数据传入
        if (!totalList.isEmpty()) {
            Map<String, List<TblTotal>> listMap = totalList.stream().collect(Collectors.groupingBy(TblTotal::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getZongshuNum());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getZongshuNum());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getZongshuNum());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }

        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    @Override
    public List<TblCondition> getXsza() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        QueryWrapper<TblTotal> queryWrapper = new QueryWrapper<>();//构建条件构造器
        //添加查询条件
        queryWrapper.select("id", "address", "time", "xingshi_num", "zhian_num");
        queryWrapper.likeLeft("address", "所");
        queryWrapper.ne("address", "柯桥区万绣所");
        queryWrapper.or().eq("address", "柯桥区");
        queryWrapper.groupBy("address", "time");
        List<TblTotal> totalList = tblTotalService.list(queryWrapper);//查到的数据传入
        if (!totalList.isEmpty()) {//总表-刑事+总表-治安
            Map<String, List<TblTotal>> listMap = totalList.stream().collect(Collectors.groupingBy(TblTotal::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数 总表-刑事+总表-治安
                        tblCondition.setBenqiNum(item.getXingshiNum() + item.getZhianNum());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getXingshiNum() + item.getZhianNum());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getXingshiNum() + item.getZhianNum());
                    }
                });
                //计算刑事和治安警情同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算刑事和治安警情环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);

                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    @Override
    public List<TblCondition> getXs() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        QueryWrapper<TblTotal> queryWrapper = new QueryWrapper<>();//构建条件构造器
        //添加查询条件
        queryWrapper.select("id", "address", "time", "xingshi_num", "zhian_num");
        queryWrapper.likeLeft("address", "所");
        queryWrapper.ne("address", "柯桥区万绣所");
        queryWrapper.or().eq("address", "柯桥区");
        queryWrapper.groupBy("address", "time");
        List<TblTotal> totalList = tblTotalService.list(queryWrapper);//查到的数据传入
        if (!totalList.isEmpty()) {//总表-刑事
            Map<String, List<TblTotal>> listMap = totalList.stream().collect(Collectors.groupingBy(TblTotal::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数 总表-刑事
                        tblCondition.setBenqiNum(item.getXingshiNum());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getXingshiNum());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getXingshiNum());
                    }
                });
                //计算刑事和治安警情同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算刑事和治安警情环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;

    }

    @Override
    public List<TblCondition> getZa() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        QueryWrapper<TblTotal> queryWrapper = new QueryWrapper<>();//构建条件构造器
        //添加查询条件
        queryWrapper.select("id", "address", "time", "xingshi_num", "zhian_num");
        queryWrapper.likeLeft("address", "所");
        queryWrapper.ne("address", "柯桥区万绣所");
        queryWrapper.or().eq("address", "柯桥区");
        queryWrapper.groupBy("address", "time");
        List<TblTotal> totalList = tblTotalService.list(queryWrapper);//查到的数据传入
        if (!totalList.isEmpty()) {//总表-治安
            Map<String, List<TblTotal>> listMap = totalList.stream().collect(Collectors.groupingBy(TblTotal::getAddress));
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数 总表-治安
                        tblCondition.setBenqiNum(item.getZhianNum());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getZhianNum());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getZhianNum());
                    }
                });
                //计算刑事和治安警情同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算刑事和治安警情环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        List<String>county= Arrays.asList("柯桥区柯桥所","柯桥区钱清所","柯桥区齐贤所","柯桥区杨汛所","柯桥区马鞍所","柯桥区柯岩所"
                ,"柯桥区福全所","柯桥区华舍所","柯桥区安昌所","柯桥区平水所","柯桥区兰亭所","柯桥区漓渚所","柯桥区夏履所"
                ,"柯桥区湖塘所","柯桥区王坛所","柯桥区稽东所","柯桥区轻纺所","柯桥区");

        for (int i=0;i<county.size();i++){
            for (TblCondition tblCondition:resultList){
                if (tblCondition.getAddress().equals(county.get(i))){
                    tblCondition.setOrdNum(i);
                }
            }
        }
        resultList.sort(new Comparator<TblCondition>() {
            @Override
            public int compare(TblCondition o1, TblCondition o2) {
                return o1.getOrdNum().compareTo(o2.getOrdNum());
            }
        });
        return resultList;
    }

    @Override
    public List<TblCondition> getzjjl() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        List<TotalCount> totalCountList = tongjiMapper.selectzjjl();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> selecall() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        List<TblZongqjDto> totalCountList = tongjiMapper.selecall();

        if (!totalCountList.isEmpty()) {
            Map<String, List<TblZongqjDto>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TblZongqjDto::getGxAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTCt());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTCt());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTCt());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> getxszjjf() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        List<TblZongqjDto> totalCountList = tongjiMapper.selectxszajf();

        if (!totalCountList.isEmpty()) {
            Map<String, List<TblZongqjDto>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TblZongqjDto::getGxAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTCt());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTCt());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTCt());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> getcxqc() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        List<TblZongqjDto> totalCountList = tongjiMapper.selectctqc();

        if (!totalCountList.isEmpty()) {
            Map<String, List<TblZongqjDto>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TblZongqjDto::getGxAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTCt());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTCt());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTCt());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> gethdjq() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        //查询传统侵财警情：（刑事-偷盗类+抢劫+抢夺+其他诈骗）+ （治安-偷盗类+抢劫+抢夺+其他诈骗）
        List<TotalCount> totalCountList = tongjiMapper.selectCtqcjq1();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> gettxwl() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        List<TblZongqjDto> totalCountList = tongjiMapper.selecttxwl();

        if (!totalCountList.isEmpty()) {
            Map<String, List<TblZongqjDto>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TblZongqjDto::getGxAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTCt());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTCt());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTCt());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> getjf() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        List<TblZongqjDto> totalCountList = tongjiMapper.selectjf();

        if (!totalCountList.isEmpty()) {
            Map<String, List<TblZongqjDto>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TblZongqjDto::getGxAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTCt());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTCt());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTCt());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> getjtsg() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        //查询传统侵财警情：（刑事-偷盗类+抢劫+抢夺+其他诈骗）+ （治安-偷盗类+抢劫+抢夺+其他诈骗）
        List<TotalCount> totalCountList = tongjiMapper.selectjtsg();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> gethzjq() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        List<TotalCount> totalCountList = tongjiMapper.selecthzjq();
        if (!totalCountList.isEmpty()) {
            Map<String, List<TotalCount>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TotalCount::getAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTotal());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTotal());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTotal());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }

    @Override
    public List<TblCondition> getqz() {
        List<TblCondition> resultList = new ArrayList<TblCondition>();
        List<TblZongqjDto> totalCountList = tongjiMapper.selectqz();

        if (!totalCountList.isEmpty()) {
            Map<String, List<TblZongqjDto>> listMap = totalCountList.stream().collect(Collectors.groupingBy(TblZongqjDto::getGxAddress));//排序，传值
            listMap.forEach((k, v) -> {
                TblCondition tblCondition = new TblCondition();
                //获取单位单位
                tblCondition.setAddress(k);
                v.forEach(item -> {
                    if ("本期".equals(item.getTime())) {
                        //获取本期数
                        tblCondition.setBenqiNum(item.getTCt());
                    }
                    if ("上期".equals(item.getTime())) {
                        //获取上期数
                        tblCondition.setShangqiNum(item.getTCt());
                    }
                    if ("去年同期".equals(item.getTime())) {
                        //获取去年同期数
                        tblCondition.setQunianNum(item.getTCt());
                    }
                });
                //计算同比
                String tb = ComputeUtils.getGrowthRate(tblCondition.getQunianNum(), tblCondition.getBenqiNum());
                tblCondition.setTongbiNum(tb);
                //计算环比
                String hb = ComputeUtils.getGrowthRate(tblCondition.getShangqiNum(), tblCondition.getBenqiNum());
                tblCondition.setHuanbiNum(hb);
                resultList.add(tblCondition);
            });
        }
        return resultList;
    }


    @Override
    public void addjb() {
        tongjiMapper.updatejb();
    }

    @Override
    public void addxs() {
        tongjiMapper.updatexs();
    }

    @Override
    public void addza() {
        tongjiMapper.updateza();
    }

    @Override
    public void addtotal() {
        tongjiMapper.updatetotal();
    }

    @Override
    public void updategx() {
        tongjiMapper.updategxadd();
    }


}
