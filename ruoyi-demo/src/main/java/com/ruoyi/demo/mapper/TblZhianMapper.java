package com.ruoyi.demo.mapper;

import java.util.List;
import com.ruoyi.demo.domain.TblZhian;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 治安Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Mapper
public interface TblZhianMapper extends BaseMapper<TblZhian> {
    /**
     * 查询治安
     * 
     * @param id 治安主键
     * @return 治安
     */
    public TblZhian selectTblZhianById(Long id);

    /**
     * 查询治安列表
     * 
     * @param tblZhian 治安
     * @return 治安集合
     */
    public List<TblZhian> selectTblZhianList(TblZhian tblZhian);

    /**
     * 新增治安
     * 
     * @param tblZhian 治安
     * @return 结果
     */
    public int insertTblZhian(TblZhian tblZhian);

    /**
     * 修改治安
     * 
     * @param tblZhian 治安
     * @return 结果
     */
    public int updateTblZhian(TblZhian tblZhian);

    /**
     * 删除治安
     * 
     * @param id 治安主键
     * @return 结果
     */
    public int deleteTblZhianById(Long id);

    /**
     * 批量删除治安
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblZhianByIds(Long[] ids);

    public void truncateTable();
}
