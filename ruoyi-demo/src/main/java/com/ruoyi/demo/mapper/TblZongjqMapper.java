package com.ruoyi.demo.mapper;

import java.util.List;
import com.ruoyi.demo.domain.TblZongjq;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 总警情Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
public interface TblZongjqMapper extends BaseMapper<TblZongjq> {
    /**
     * 查询总警情
     * 
     * @param type 总警情主键
     * @return 总警情
     */
    public TblZongjq selectTblZongjqByType(String type);

    /**
     * 查询总警情列表
     * 
     * @param tblZongjq 总警情
     * @return 总警情集合
     */
    public List<TblZongjq> selectTblZongjqList(TblZongjq tblZongjq);

    /**
     * 新增总警情
     * 
     * @param tblZongjq 总警情
     * @return 结果
     */
    public int insertTblZongjq(TblZongjq tblZongjq);

    /**
     * 修改总警情
     * 
     * @param tblZongjq 总警情
     * @return 结果
     */
    public int updateTblZongjq(TblZongjq tblZongjq);

    /**
     * 删除总警情
     * 
     * @param type 总警情主键
     * @return 结果
     */
    public int deleteTblZongjqByType(String type);

    /**
     * 批量删除总警情
     * 
     * @param types 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblZongjqByTypes(String[] types);

    public void truncateTable();
}
