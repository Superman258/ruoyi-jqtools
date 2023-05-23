package com.ruoyi.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.demo.mapper.TblXingshiMapper;
import com.ruoyi.demo.domain.TblXingshi;
import com.ruoyi.demo.service.ITblXingshiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

/**
 * 刑事表Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Service
public class TblXingshiServiceImpl extends ServiceImpl<TblXingshiMapper, TblXingshi> implements ITblXingshiService {
    @Resource
    private TblXingshiMapper tblXingshiMapper;

    /**
     * 查询刑事表
     * 
     * @param id 刑事表主键
     * @return 刑事表
     */
    @Override
    public TblXingshi selectTblXingshiById(Long id)
    {
        return tblXingshiMapper.selectTblXingshiById(id);
    }

    /**
     * 查询刑事表列表
     * 
     * @param tblXingshi 刑事表
     * @return 刑事表
     */
    @Override
    public List<TblXingshi> selectTblXingshiList(TblXingshi tblXingshi)
    {
        return tblXingshiMapper.selectTblXingshiList(tblXingshi);
    }

    /**
     * 新增刑事表
     * 
     * @param tblXingshi 刑事表
     * @return 结果
     */
    @Override
    public int insertTblXingshi(TblXingshi tblXingshi)
    {
        return tblXingshiMapper.insertTblXingshi(tblXingshi);
    }

    /**
     * 修改刑事表
     * 
     * @param tblXingshi 刑事表
     * @return 结果
     */
    @Override
    public int updateTblXingshi(TblXingshi tblXingshi)
    {
        return tblXingshiMapper.updateTblXingshi(tblXingshi);
    }

    /**
     * 批量删除刑事表
     * 
     * @param ids 需要删除的刑事表主键
     * @return 结果
     */
    @Override
    public int deleteTblXingshiByIds(Long[] ids)
    {
        return tblXingshiMapper.deleteTblXingshiByIds(ids);
    }

    /**
     * 删除刑事表信息
     * 
     * @param id 刑事表主键
     * @return 结果
     */
    @Override
    public int deleteTblXingshiById(Long id)
    {
        return tblXingshiMapper.deleteTblXingshiById(id);
    }
}
