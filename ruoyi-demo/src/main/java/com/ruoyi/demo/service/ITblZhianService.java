package com.ruoyi.demo.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.demo.domain.TblZhian;

/**
 * 治安Service接口
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
public interface ITblZhianService extends IService<TblZhian> {
    /**
     * 查询治安
     * 
     * @param id 治安主键
     * @return 治安
     */
    public TblZhian selectTblZhianById(Long id);

    /**
     * 查询治安列表
     * 
     * @param tblZhian 治安
     * @return 治安集合
     */
    public List<TblZhian> selectTblZhianList(TblZhian tblZhian);

    /**
     * 新增治安
     * 
     * @param tblZhian 治安
     * @return 结果
     */
    public int insertTblZhian(TblZhian tblZhian);

    /**
     * 修改治安
     * 
     * @param tblZhian 治安
     * @return 结果
     */
    public int updateTblZhian(TblZhian tblZhian);

    /**
     * 批量删除治安
     * 
     * @param ids 需要删除的治安主键集合
     * @return 结果
     */
    public int deleteTblZhianByIds(Long[] ids);

    /**
     * 删除治安信息
     * 
     * @param id 治安主键
     * @return 结果
     */
    public int deleteTblZhianById(Long id);
}
