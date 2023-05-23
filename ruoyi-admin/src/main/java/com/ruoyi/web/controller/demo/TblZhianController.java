package com.ruoyi.web.controller.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.demo.domain.TblTotal;
import com.ruoyi.demo.domain.TblXingshi;
import com.ruoyi.demo.domain.TblZhian;
import com.ruoyi.demo.service.ITblZhianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 治安Controller
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Api(value = "治安管理",tags = "治安管理")
@RestController
@RequestMapping("/demo/zhian")
public class TblZhianController extends BaseController
{
    @Autowired
    private ITblZhianService tblZhianService;

    /**
     * 查询治安列表
     */
    @ApiOperation("查询治安列表")
    @PreAuthorize("@ss.hasPermi('demo:zhian:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblZhian tblZhian)
    {
        startPage();
        List<TblZhian> list = tblZhianService.selectTblZhianList(tblZhian);
        return getDataTable(list);
    }

    /**
     * 导出治安列表
     */
    @ApiOperation("导出治安列表")
    @PreAuthorize("@ss.hasPermi('demo:zhian:export')")
    @Log(title = "治安", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblZhian tblZhian)
    {
        List<TblZhian> list = tblZhianService.selectTblZhianList(tblZhian);
        ExcelUtil<TblZhian> util = new ExcelUtil<TblZhian>(TblZhian.class);
        util.exportExcel(response, list, "治安数据");
    }

    /**
     * 获取治安详细信息
     */
    @ApiOperation("获取治安详细信息")
    @PreAuthorize("@ss.hasPermi('demo:zhian:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tblZhianService.selectTblZhianById(id));
    }

    /**
     * 新增治安
     */
    @ApiOperation("新增治安")
    @PreAuthorize("@ss.hasPermi('demo:zhian:add')")
    @Log(title = "治安", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblZhian tblZhian)
    {
        return toAjax(tblZhianService.insertTblZhian(tblZhian));
    }

    /**
     * 修改治安
     */
    @ApiOperation("修改治安")
    @PreAuthorize("@ss.hasPermi('demo:zhian:edit')")
    @Log(title = "治安", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblZhian tblZhian)
    {
        return toAjax(tblZhianService.updateTblZhian(tblZhian));
    }

    /**
     * 删除治安
     */
    @ApiOperation("删除治安")
    @PreAuthorize("@ss.hasPermi('demo:zhian:remove')")
    @Log(title = "治安", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tblZhianService.deleteTblZhianByIds(ids));
    }

    @ApiOperation("导入治安表列表")
    @PreAuthorize("@ss.hasPermi('system:tbltotal:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file,String time) throws Exception
    {
        LambdaQueryWrapper<TblZhian> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblZhian::getTime, time);
        tblZhianService.remove(queryWrapper);
        ExcelUtil<TblZhian> util = new ExcelUtil<TblZhian>(TblZhian.class);
        List<TblZhian> tblZhianList = util.importExcel(file.getInputStream());
        tblZhianService.saveBatch(tblZhianList);
        return AjaxResult.success();
    }

    @ApiOperation("导出治安表列表模板")
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<TblZhian> util = new ExcelUtil<TblZhian>(TblZhian.class);
        util.importTemplateExcel(response, "治安表数据");
    }

    @ApiOperation("删除治安表列表模板")
    @DeleteMapping("/clean")
    public String delete(String time){
        LambdaQueryWrapper<TblZhian> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblZhian::getTime, time);
        tblZhianService.remove(queryWrapper);
        return "已删除";
    }
}
