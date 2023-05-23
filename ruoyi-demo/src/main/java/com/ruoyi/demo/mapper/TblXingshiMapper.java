package com.ruoyi.demo.mapper;

import java.util.List;
import com.ruoyi.demo.domain.TblXingshi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 刑事表Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Mapper
public interface TblXingshiMapper extends BaseMapper<TblXingshi> {
    /**
     * 查询刑事表
     * 
     * @param id 刑事表主键
     * @return 刑事表
     */
    public TblXingshi selectTblXingshiById(Long id);

    /**
     * 查询刑事表列表
     * 
     * @param tblXingshi 刑事表
     * @return 刑事表集合
     */
    public List<TblXingshi> selectTblXingshiList(TblXingshi tblXingshi);

    /**
     * 新增刑事表
     * 
     * @param tblXingshi 刑事表
     * @return 结果
     */
    public int insertTblXingshi(TblXingshi tblXingshi);

    /**
     * 修改刑事表
     * 
     * @param tblXingshi 刑事表
     * @return 结果
     */
    public int updateTblXingshi(TblXingshi tblXingshi);

    /**
     * 删除刑事表
     * 
     * @param id 刑事表主键
     * @return 结果
     */
    public int deleteTblXingshiById(Long id);

    /**
     * 批量删除刑事表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblXingshiByIds(Long[] ids);

    public void truncateTable();

}
