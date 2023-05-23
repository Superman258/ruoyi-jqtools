package com.ruoyi.demo.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.demo.mapper.TblJubaoMapper;
import com.ruoyi.demo.domain.TblJubao;
import com.ruoyi.demo.service.ITblJubaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

/**
 * 举报表Service业务层处理
 *
 * @author ruoyi
 * @date 2022-08-24
 */
@Service
public class TblJubaoServiceImpl extends ServiceImpl<TblJubaoMapper, TblJubao> implements ITblJubaoService {
    @Resource
    private TblJubaoMapper tblJubaoMapper;

    /**
     * 查询举报表
     *
     * @param id 举报表主键
     * @return 举报表
     */
    @Override
    public TblJubao selectTblJubaoById(Long id) {
        return tblJubaoMapper.selectTblJubaoById(id);
    }

    /**
     * 查询举报表列表
     *
     * @param tblJubao 举报表
     * @return 举报表
     */
    @Override
    public List<TblJubao> selectTblJubaoList(TblJubao tblJubao) {
        return tblJubaoMapper.selectTblJubaoList(tblJubao);
    }

    /**
     * 新增举报表
     *
     * @param tblJubao 举报表
     * @return 结果
     */
    @Override
    public int insertTblJubao(TblJubao tblJubao) {
        return tblJubaoMapper.insertTblJubao(tblJubao);
    }

    /**
     * 修改举报表
     *
     * @param tblJubao 举报表
     * @return 结果
     */
    @Override
    public int updateTblJubao(TblJubao tblJubao) {
        return tblJubaoMapper.updateTblJubao(tblJubao);
    }

    /**
     * 批量删除举报表
     *
     * @param ids 需要删除的举报表主键
     * @return 结果
     */
    @Override
    public int deleteTblJubaoByIds(Long[] ids) {
        return tblJubaoMapper.deleteTblJubaoByIds(ids);
    }

    /**
     * 删除举报表信息
     *
     * @param id 举报表主键
     * @return 结果
     */
    @Override
    public int deleteTblJubaoById(Long id) {
        return tblJubaoMapper.deleteTblJubaoById(id);
    }


}
