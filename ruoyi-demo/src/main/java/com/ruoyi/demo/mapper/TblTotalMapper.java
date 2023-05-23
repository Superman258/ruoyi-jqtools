package com.ruoyi.demo.mapper;

import java.util.List;

import com.ruoyi.demo.domain.TblJubao;
import com.ruoyi.demo.domain.TblTotal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 总表Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Mapper
public interface TblTotalMapper extends BaseMapper<TblTotal> {
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
     * 删除总表
     * 
     * @param id 总表主键
     * @return 结果
     */
    public int deleteTblTotalById(Long id);

    /**
     * 批量删除总表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblTotalByIds(Long[] ids);

    public void truncateTable();

}
