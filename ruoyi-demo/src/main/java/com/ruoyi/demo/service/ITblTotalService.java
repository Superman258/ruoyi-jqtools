package com.ruoyi.demo.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.demo.domain.TblTotal;

/**
 * 总表Service接口
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
public interface ITblTotalService extends IService<TblTotal> {
    /**
     * 查询总表
     * 
     * @param id 总表主键
     * @return 总表
     */
    public TblTotal selectTblTotalById(Long id);

    /**
     * 查询总表列表
     * 
     * @param tblTotal 总表
     * @return 总表集合
     */
    public List<TblTotal> selectTblTotalList(TblTotal tblTotal);

    /**
     * 新增总表
     * 
     * @param tblTotal 总表
     * @return 结果
     */
    public int insertTblTotal(TblTotal tblTotal);

    /**
     * 修改总表
     * 
     * @param tblTotal 总表
     * @return 结果
     */
    public int updateTblTotal(TblTotal tblTotal);

    /**
     * 批量删除总表
     * 
     * @param ids 需要删除的总表主键集合
     * @return 结果
     */
    public int deleteTblTotalByIds(Long[] ids);

    /**
     * 删除总表信息
     * 
     * @param id 总表主键
     * @return 结果
     */
    public int deleteTblTotalById(Long id);

}
