package com.ruoyi.demo.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.demo.domain.TblXingshi;

/**
 * 刑事表Service接口
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
public interface ITblXingshiService extends IService<TblXingshi> {
    /**
     * 查询刑事表
     * 
     * @param id 刑事表主键
     * @return 刑事表
     */
    public TblXingshi selectTblXingshiById(Long id);

    /**
     * 查询刑事表列表
     * 
     * @param tblXingshi 刑事表
     * @return 刑事表集合
     */
    public List<TblXingshi> selectTblXingshiList(TblXingshi tblXingshi);

    /**
     * 新增刑事表
     * 
     * @param tblXingshi 刑事表
     * @return 结果
     */
    public int insertTblXingshi(TblXingshi tblXingshi);

    /**
     * 修改刑事表
     * 
     * @param tblXingshi 刑事表
     * @return 结果
     */
    public int updateTblXingshi(TblXingshi tblXingshi);

    /**
     * 批量删除刑事表
     * 
     * @param ids 需要删除的刑事表主键集合
     * @return 结果
     */
    public int deleteTblXingshiByIds(Long[] ids);

    /**
     * 删除刑事表信息
     * 
     * @param id 刑事表主键
     * @return 结果
     */
    public int deleteTblXingshiById(Long id);
}
