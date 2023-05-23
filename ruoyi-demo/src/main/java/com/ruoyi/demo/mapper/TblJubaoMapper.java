package com.ruoyi.demo.mapper;

import java.util.List;
import com.ruoyi.demo.domain.TblJubao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 举报表Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Mapper
public interface TblJubaoMapper extends BaseMapper<TblJubao> {
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
     * 删除举报表
     * 
     * @param id 举报表主键
     * @return 结果
     */
    public int deleteTblJubaoById(Long id);

    /**
     * 批量删除举报表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblJubaoByIds(Long[] ids);

    public void truncateTable();

}
