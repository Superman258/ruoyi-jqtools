package com.ruoyi.web.controller.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.demo.domain.TblJubao;
import com.ruoyi.demo.domain.TblTotal;
import com.ruoyi.demo.service.ITblTotalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 总表Controller
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Api(value = "总表管理",tags = "总表管理")
@RestController
@RequestMapping("/demo/total")
public class TblTotalController extends BaseController
{
    @Autowired
    private ITblTotalService tblTotalService;

    /**
     * 查询总表列表
     */
    @ApiOperation("查询总表列表")
    @PreAuthorize("@ss.hasPermi('demo:total:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblTotal tblTotal)
    {
        startPage();
        List<TblTotal> list = tblTotalService.selectTblTotalList(tblTotal);
        return getDataTable(list);
    }

    /**
     * 导出总表列表
     */
    @ApiOperation("导出总表列表")
    @PreAuthorize("@ss.hasPermi('demo:total:export')")
    @Log(title = "总表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblTotal tblTotal)
    {
        List<TblTotal> list = tblTotalService.selectTblTotalList(tblTotal);
        ExcelUtil<TblTotal> util = new ExcelUtil<TblTotal>(TblTotal.class);
        util.exportExcel(response, list, "总表数据");
    }

    /**
     * 获取总表详细信息
     */
    @ApiOperation("获取总表详细信息")
    @PreAuthorize("@ss.hasPermi('demo:total:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tblTotalService.selectTblTotalById(id));
    }

    /**
     * 新增总表
     */
    @ApiOperation("新增总表")
    @PreAuthorize("@ss.hasPermi('demo:total:add')")
    @Log(title = "总表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblTotal tblTotal)
    {
        return toAjax(tblTotalService.insertTblTotal(tblTotal));
    }

    /**
     * 修改总表
     */
    @ApiOperation("修改总表")
    @PreAuthorize("@ss.hasPermi('demo:total:edit')")
    @Log(title = "总表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblTotal tblTotal)
    {
        return toAjax(tblTotalService.updateTblTotal(tblTotal));
    }

    /**
     * 删除总表
     */
    @ApiOperation("删除总表")
    @PreAuthorize("@ss.hasPermi('demo:total:remove')")
    @Log(title = "总表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tblTotalService.deleteTblTotalByIds(ids));
    }

    @ApiOperation("导入总表")
    @PreAuthorize("@ss.hasPermi('system:tbltotal:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file,String time) throws Exception
    {
        LambdaQueryWrapper<TblTotal> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblTotal::getTime, time);
        tblTotalService.remove(queryWrapper);
        ExcelUtil<TblTotal> util = new ExcelUtil<TblTotal>(TblTotal.class);
        List<TblTotal> tblTotalList = util.importExcel(file.getInputStream());
        tblTotalService.saveBatch(tblTotalList);
        return AjaxResult.success();
    }

    @ApiOperation("导出总表模板")
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<TblTotal> util = new ExcelUtil<TblTotal>(TblTotal.class);
        util.importTemplateExcel(response, "总表数据");
    }

    @ApiOperation("清除总表")
    @DeleteMapping("/clean")
    public String delete(String time){
        LambdaQueryWrapper<TblTotal> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblTotal::getTime, time);
        tblTotalService.remove(queryWrapper);
        return "已删除";
    }
}
