package com.ruoyi.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.demo.mapper.TblTotalMapper;
import com.ruoyi.demo.domain.TblTotal;
import com.ruoyi.demo.service.ITblTotalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

/**
 * 总表Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Service
public class TblTotalServiceImpl extends ServiceImpl<TblTotalMapper, TblTotal> implements ITblTotalService {
    @Resource
    private TblTotalMapper tblTotalMapper;

    /**
     * 查询总表
     * 
     * @param id 总表主键
     * @return 总表
     */
    @Override
    public TblTotal selectTblTotalById(Long id)
    {
        return tblTotalMapper.selectTblTotalById(id);
    }

    /**
     * 查询总表列表
     * 
     * @param tblTotal 总表
     * @return 总表
     */
    @Override
    public List<TblTotal> selectTblTotalList(TblTotal tblTotal)
    {
        return tblTotalMapper.selectTblTotalList(tblTotal);
    }

    /**
     * 新增总表
     * 
     * @param tblTotal 总表
     * @return 结果
     */
    @Override
    public int insertTblTotal(TblTotal tblTotal)
    {
        return tblTotalMapper.insertTblTotal(tblTotal);
    }

    /**
     * 修改总表
     * 
     * @param tblTotal 总表
     * @return 结果
     */
    @Override
    public int updateTblTotal(TblTotal tblTotal)
    {
        return tblTotalMapper.updateTblTotal(tblTotal);
    }

    /**
     * 批量删除总表
     * 
     * @param ids 需要删除的总表主键
     * @return 结果
     */
    @Override
    public int deleteTblTotalByIds(Long[] ids)
    {
        return tblTotalMapper.deleteTblTotalByIds(ids);
    }

    /**
     * 删除总表信息
     * 
     * @param id 总表主键
     * @return 结果
     */
    @Override
    public int deleteTblTotalById(Long id)
    {
        return tblTotalMapper.deleteTblTotalById(id);
    }
}
