package com.ruoyi.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.demo.mapper.TblZhianMapper;
import com.ruoyi.demo.domain.TblZhian;
import com.ruoyi.demo.service.ITblZhianService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

/**
 * 治安Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Service
public class TblZhianServiceImpl extends ServiceImpl<TblZhianMapper, TblZhian> implements ITblZhianService {
    @Resource
    private TblZhianMapper tblZhianMapper;

    /**
     * 查询治安
     * 
     * @param id 治安主键
     * @return 治安
     */
    @Override
    public TblZhian selectTblZhianById(Long id)
    {
        return tblZhianMapper.selectTblZhianById(id);
    }

    /**
     * 查询治安列表
     * 
     * @param tblZhian 治安
     * @return 治安
     */
    @Override
    public List<TblZhian> selectTblZhianList(TblZhian tblZhian)
    {
        return tblZhianMapper.selectTblZhianList(tblZhian);
    }

    /**
     * 新增治安
     * 
     * @param tblZhian 治安
     * @return 结果
     */
    @Override
    public int insertTblZhian(TblZhian tblZhian)
    {
        return tblZhianMapper.insertTblZhian(tblZhian);
    }

    /**
     * 修改治安
     * 
     * @param tblZhian 治安
     * @return 结果
     */
    @Override
    public int updateTblZhian(TblZhian tblZhian)
    {
        return tblZhianMapper.updateTblZhian(tblZhian);
    }

    /**
     * 批量删除治安
     * 
     * @param ids 需要删除的治安主键
     * @return 结果
     */
    @Override
    public int deleteTblZhianByIds(Long[] ids)
    {
        return tblZhianMapper.deleteTblZhianByIds(ids);
    }

    /**
     * 删除治安信息
     * 
     * @param id 治安主键
     * @return 结果
     */
    @Override
    public int deleteTblZhianById(Long id)
    {
        return tblZhianMapper.deleteTblZhianById(id);
    }
}
