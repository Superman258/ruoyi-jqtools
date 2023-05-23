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
import com.ruoyi.demo.service.ITblXingshiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 刑事表Controller
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Api(value = "刑事表管理",tags = "刑事表管理")
@RestController
@RequestMapping("/demo/xingshi")
public class TblXingshiController extends BaseController
{
    @Autowired
    private ITblXingshiService tblXingshiService;

    /**
     * 查询刑事表列表
     */
    @ApiOperation("查询刑事表列表")
    @PreAuthorize("@ss.hasPermi('demo:xingshi:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblXingshi tblXingshi)
    {
        startPage();
        List<TblXingshi> list = tblXingshiService.selectTblXingshiList(tblXingshi);
        return getDataTable(list);
    }

    /**
     * 导出刑事表列表
     */
    @ApiOperation("导出刑事表列表")
    @PreAuthorize("@ss.hasPermi('demo:xingshi:export')")
    @Log(title = "刑事表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblXingshi tblXingshi)
    {
        List<TblXingshi> list = tblXingshiService.selectTblXingshiList(tblXingshi);
        ExcelUtil<TblXingshi> util = new ExcelUtil<TblXingshi>(TblXingshi.class);
        util.exportExcel(response, list, "刑事表数据");
    }

    /**
     * 获取刑事表详细信息
     */
    @ApiOperation("获取刑事表详细信息")
    @PreAuthorize("@ss.hasPermi('demo:xingshi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tblXingshiService.selectTblXingshiById(id));
    }

    /**
     * 新增刑事表
     */
    @ApiOperation("新增刑事表")
    @PreAuthorize("@ss.hasPermi('demo:xingshi:add')")
    @Log(title = "刑事表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblXingshi tblXingshi)
    {
        return toAjax(tblXingshiService.insertTblXingshi(tblXingshi));
    }

    /**
     * 修改刑事表
     */
    @ApiOperation("修改刑事表")
    @PreAuthorize("@ss.hasPermi('demo:xingshi:edit')")
    @Log(title = "刑事表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblXingshi tblXingshi)
    {
        return toAjax(tblXingshiService.updateTblXingshi(tblXingshi));
    }

    /**
     * 删除刑事表
     */
    @ApiOperation("删除刑事表")
    @PreAuthorize("@ss.hasPermi('demo:xingshi:remove')")
    @Log(title = "刑事表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tblXingshiService.deleteTblXingshiByIds(ids));
    }

    @ApiOperation("导入刑事表列表")
    @PreAuthorize("@ss.hasPermi('system:tbltotal:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file,String time) throws Exception
    {
        LambdaQueryWrapper<TblXingshi> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblXingshi::getTime, time);
        tblXingshiService.remove(queryWrapper);
        ExcelUtil<TblXingshi> util = new ExcelUtil<TblXingshi>(TblXingshi.class);
        List<TblXingshi> tblXingshiList = util.importExcel(file.getInputStream());
        tblXingshiService.saveBatch(tblXingshiList);
        return AjaxResult.success();
    }

    @ApiOperation("导出刑事表列表模板")
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<TblXingshi> util = new ExcelUtil<TblXingshi>(TblXingshi.class);
        util.importTemplateExcel(response, "刑事表数据");
    }

    @ApiOperation("删除刑事表列表模板")
    @DeleteMapping("/clean")
    public String delete(String time){
        LambdaQueryWrapper<TblXingshi> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblXingshi::getTime, time);
        tblXingshiService.remove(queryWrapper);
        return "已删除";
    }
}
