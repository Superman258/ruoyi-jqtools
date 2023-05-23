package com.ruoyi.web.controller.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.demo.domain.TblJubao;
import com.ruoyi.demo.domain.TblTotal;
import com.ruoyi.demo.domain.TblZhian;
import com.ruoyi.demo.service.ITblJubaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 举报表Controller
 * 
 * @author ruoyi
 * @date 2022-08-24
 */
@Api(value = "举报表管理",tags = "举报表管理")
@RestController
@RequestMapping("/demo/jubao")
public class TblJubaoController extends BaseController
{
    @Autowired
    private ITblJubaoService tblJubaoService;

    /**
     * 查询举报表列表
     */
    @ApiOperation("查询举报表列表")
    @PreAuthorize("@ss.hasPermi('demo:jubao:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblJubao tblJubao)
    {
        startPage();
        List<TblJubao> list = tblJubaoService.selectTblJubaoList(tblJubao);
        return getDataTable(list);
    }

    /**
     * 导出举报表列表
     */
    @ApiOperation("导出举报表列表")
    @PreAuthorize("@ss.hasPermi('demo:jubao:export')")
    @Log(title = "举报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblJubao tblJubao)
    {
        List<TblJubao> list = tblJubaoService.selectTblJubaoList(tblJubao);
        ExcelUtil<TblJubao> util = new ExcelUtil<TblJubao>(TblJubao.class);
        util.exportExcel(response, list, "举报表数据");
    }

    /**
     * 获取举报表详细信息
     */
    @ApiOperation("获取举报表详细信息")
    @PreAuthorize("@ss.hasPermi('demo:jubao:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tblJubaoService.selectTblJubaoById(id));
    }

    /**
     * 新增举报表
     */
    @ApiOperation("新增举报表")
    @PreAuthorize("@ss.hasPermi('demo:jubao:add')")
    @Log(title = "举报表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblJubao tblJubao)
    {
        return toAjax(tblJubaoService.insertTblJubao(tblJubao));
    }

    /**
     * 修改举报表
     */
    @ApiOperation("修改举报表")
    @PreAuthorize("@ss.hasPermi('demo:jubao:edit')")
    @Log(title = "举报表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblJubao tblJubao)
    {
        return toAjax(tblJubaoService.updateTblJubao(tblJubao));
    }

    /**
     * 删除举报表
     */
    @ApiOperation("删除举报表")
    @PreAuthorize("@ss.hasPermi('demo:jubao:remove')")
    @Log(title = "举报表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tblJubaoService.deleteTblJubaoByIds(ids));
    }

    //@Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @ApiOperation("导入举报表列表")
    @PreAuthorize("@ss.hasPermi('system:tbljubao:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file,String time) throws Exception
    {
        LambdaQueryWrapper<TblJubao> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblJubao::getTime, time);
        tblJubaoService.remove(queryWrapper);
        ExcelUtil<TblJubao> util = new ExcelUtil<TblJubao>(TblJubao.class);
        List<TblJubao> jubaoList = util.importExcel(file.getInputStream());
        tblJubaoService.saveBatch(jubaoList);
        return AjaxResult.success();
    }

    @ApiOperation("导出举报表列表模板")
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<TblJubao> util = new ExcelUtil<TblJubao>(TblJubao.class);
        util.importTemplateExcel(response, "举报信息数据");
    }

    @ApiOperation("删除举报表列表模板")
    @DeleteMapping("/clean")
    public String delete(String time){
        LambdaQueryWrapper<TblJubao> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblJubao::getTime, time);
        tblJubaoService.remove(queryWrapper);
        return "已删除";
    }

}
