package com.ruoyi.demo.service;

import com.ruoyi.demo.domain.TblCondition;
import com.ruoyi.demo.domain.TblZongjq;
import com.ruoyi.demo.dto.TblZongqjDto;

import java.util.List;

public interface TongjiService {

    /**
     * 获取传统侵财警情
     * @return
     */
    List<TblCondition> getCtqcqj();

    /**
     * 盗窃警情
     * @return
     */
    List<TblCondition> getDqqj();

    /**
     * 两抢警情
     * @return
     */
    List<TblCondition> getLqqj();

    /**
     * 其他诈骗警情
     * @return
     */
    List<TblCondition> getQtzpqj();

    /**
     * 通信诈骗
     * @return
     */
    List<TblCondition> getTxzp();

    /**
     * 打架斗殴
     * @return
     */
    List<TblCondition> getDjdo();


    /**
     * 获取黄赌警情
     */
    List<TblCondition> gethd();


    /**
     * 涉黄
     * @return
     */
    List<TblCondition> getsh();

    /**
     * 涉赌
     * @return
     */
    List<TblCondition> getsd();

    /**
     * 纠纷
     * @return
     */
    List<TblCondition> getJf();

    /**
     * 有效警情
     * @return
     */
    List<TblCondition> getYxjq();

    /**
     * 形势和治安警情
     * @return
     */
    List<TblCondition> getXsza();

    /**
     * 刑事
     * @return
     */
    List<TblCondition> getXs();

    /**
     * 治安
     * @return
     */
    List<TblCondition> getZa();

    List<TblCondition> getzjjl();

    List<TblCondition> selecall();

    List<TblCondition> getxszjjf();

    List<TblCondition> getcxqc();

    List<TblCondition> gethdjq();

    List<TblCondition> gettxwl();

    List<TblCondition> getjf();

    List<TblCondition> getjtsg();

    List<TblCondition> gethzjq();

    List<TblCondition> getqz();


    public void addjb();

    public void addxs();

    public void addza();

    public void addtotal();

    public void updategx();


}
