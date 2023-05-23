package com.ruoyi.demo.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.demo.domain.TblJubao;

/**
 * 举报表Service接口
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
public interface ITblJubaoService extends IService<TblJubao> {
    /**
     * 查询举报表
     * 
     * @param id 举报表主键
     * @return 举报表
     */
    public TblJubao selectTblJubaoById(Long id);

    /**
     * 查询举报表列表
     * 
     * @param tblJubao 举报表
     * @return 举报表集合
     */
    public List<TblJubao> selectTblJubaoList(TblJubao tblJubao);

    /**
     * 新增举报表
     * 
     * @param tblJubao 举报表
     * @return 结果
     */
    public int insertTblJubao(TblJubao tblJubao);

    /**
     * 修改举报表
     * 
     * @param tblJubao 举报表
     * @return 结果
     */
    public int updateTblJubao(TblJubao tblJubao);

    /**
     * 批量删除举报表
     * 
     * @param ids 需要删除的举报表主键集合
     * @return 结果
     */
    public int deleteTblJubaoByIds(Long[] ids);

    /**
     * 删除举报表信息
     * 
     * @param id 举报表主键
     * @return 结果
     */
    public int deleteTblJubaoById(Long id);

}
