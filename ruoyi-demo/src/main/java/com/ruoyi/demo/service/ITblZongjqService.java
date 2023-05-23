package com.ruoyi.demo.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.demo.domain.TblZongjq;

/**
 * 总警情Service接口
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
public interface ITblZongjqService extends IService<TblZongjq> {
    /**
     * 查询总警情
     * 
     * @param type 总警情主键
     * @return 总警情
     */
    public TblZongjq selectTblZongjqByType(String type);

    /**
     * 查询总警情列表
     * 
     * @param tblZongjq 总警情
     * @return 总警情集合
     */
    public List<TblZongjq> selectTblZongjqList(TblZongjq tblZongjq);

    /**
     * 新增总警情
     * 
     * @param tblZongjq 总警情
     * @return 结果
     */
    public int insertTblZongjq(TblZongjq tblZongjq);

    /**
     * 修改总警情
     * 
     * @param tblZongjq 总警情
     * @return 结果
     */
    public int updateTblZongjq(TblZongjq tblZongjq);

    /**
     * 批量删除总警情
     * 
     * @param types 需要删除的总警情主键集合
     * @return 结果
     */
    public int deleteTblZongjqByTypes(String[] types);

    /**
     * 删除总警情信息
     * 
     * @param type 总警情主键
     * @return 结果
     */
    public int deleteTblZongjqByType(String type);
}
