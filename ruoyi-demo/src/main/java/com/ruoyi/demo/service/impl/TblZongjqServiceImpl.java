package com.ruoyi.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.demo.mapper.TblZongjqMapper;
import com.ruoyi.demo.domain.TblZongjq;
import com.ruoyi.demo.service.ITblZongjqService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

/**
 * 总警情Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
@Service
public class TblZongjqServiceImpl extends ServiceImpl<TblZongjqMapper, TblZongjq> implements ITblZongjqService {
    @Resource
    private TblZongjqMapper tblZongjqMapper;

    /**
     * 查询总警情
     * 
     * @param type 总警情主键
     * @return 总警情
     */
    @Override
    public TblZongjq selectTblZongjqByType(String type)
    {
        return tblZongjqMapper.selectTblZongjqByType(type);
    }

    /**
     * 查询总警情列表
     * 
     * @param tblZongjq 总警情
     * @return 总警情
     */
    @Override
    public List<TblZongjq> selectTblZongjqList(TblZongjq tblZongjq)
    {
        return tblZongjqMapper.selectTblZongjqList(tblZongjq);
    }

    /**
     * 新增总警情
     * 
     * @param tblZongjq 总警情
     * @return 结果
     */
    @Override
    public int insertTblZongjq(TblZongjq tblZongjq)
    {
        return tblZongjqMapper.insertTblZongjq(tblZongjq);
    }

    /**
     * 修改总警情
     * 
     * @param tblZongjq 总警情
     * @return 结果
     */
    @Override
    public int updateTblZongjq(TblZongjq tblZongjq)
    {
        return tblZongjqMapper.updateTblZongjq(tblZongjq);
    }

    /**
     * 批量删除总警情
     * 
     * @param types 需要删除的总警情主键
     * @return 结果
     */
    @Override
    public int deleteTblZongjqByTypes(String[] types)
    {
        return tblZongjqMapper.deleteTblZongjqByTypes(types);
    }

    /**
     * 删除总警情信息
     * 
     * @param type 总警情主键
     * @return 结果
     */
    @Override
    public int deleteTblZongjqByType(String type)
    {
        return tblZongjqMapper.deleteTblZongjqByType(type);
    }
}
