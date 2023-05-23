package com.ruoyi.web.controller.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.demo.domain.TblZongjq;
import com.ruoyi.demo.domain.TblZongjq;
import com.ruoyi.demo.service.ITblZongjqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 总警情Controller
 *
 * @author ruoyi
 * @date 2022-09-21
 */
@Api(value = "总警情管理",tags = "总警情管理")
@RestController
@RequestMapping("/demo/zongjq")
public class TblZongjqController extends BaseController
{
    @Autowired
    private ITblZongjqService tblZongjqService;

    /**
     * 查询总警情列表
     */
    @ApiOperation("查询总警情列表")
    @PreAuthorize("@ss.hasPermi('demo:zongjq:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblZongjq tblZongjq)
    {
        startPage();
        List<TblZongjq> list = tblZongjqService.selectTblZongjqList(tblZongjq);
        return getDataTable(list);
    }

    /**
     * 导出总警情列表
     */
    @ApiOperation("导出总警情列表")
    @PreAuthorize("@ss.hasPermi('demo:zongjq:export')")
    @Log(title = "总警情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblZongjq tblZongjq)
    {
        List<TblZongjq> list = tblZongjqService.selectTblZongjqList(tblZongjq);
        ExcelUtil<TblZongjq> util = new ExcelUtil<TblZongjq>(TblZongjq.class);
        util.exportExcel(response, list, "总警情数据");
    }

    /**
     * 获取总警情详细信息
     */
    @ApiOperation("获取总警情详细信息")
    @PreAuthorize("@ss.hasPermi('demo:zongjq:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return AjaxResult.success(tblZongjqService.selectTblZongjqByType(type));
    }

    /**
     * 新增总警情
     */
    @ApiOperation("新增总警情")
    @PreAuthorize("@ss.hasPermi('demo:zongjq:add')")
    @Log(title = "总警情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblZongjq tblZongjq)
    {
        return toAjax(tblZongjqService.insertTblZongjq(tblZongjq));
    }

    /**
     * 修改总警情
     */
    @ApiOperation("修改总警情")
    @PreAuthorize("@ss.hasPermi('demo:zongjq:edit')")
    @Log(title = "总警情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblZongjq tblZongjq)
    {
        return toAjax(tblZongjqService.updateTblZongjq(tblZongjq));
    }

    /**
     * 删除总警情
     */
    @ApiOperation("删除总警情")
    @PreAuthorize("@ss.hasPermi('demo:zongjq:remove')")
    @Log(title = "总警情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(tblZongjqService.deleteTblZongjqByTypes(types));
    }

    @ApiOperation("导入总警情表列表")
    @PreAuthorize("@ss.hasPermi('system:tblzongjq:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, String time) throws Exception
    {
        LambdaQueryWrapper<TblZongjq> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblZongjq::getTime, time);
        tblZongjqService.remove(queryWrapper);
        ExcelUtil<TblZongjq> util = new ExcelUtil<TblZongjq>(TblZongjq.class);
        List<TblZongjq> tblZongjqList = util.importExcel(file.getInputStream());
        for (int i = 0; i < tblZongjqList.size(); i++) {
            tblZongjqList.get(i).setTime(time);
        }
        tblZongjqService.saveBatch(tblZongjqList);
        return AjaxResult.success();
    }

    @ApiOperation("导出总警情表列表模板")
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<TblZongjq> util = new ExcelUtil<TblZongjq>(TblZongjq.class);
        util.importTemplateExcel(response, "总警情表数据");
    }

    @ApiOperation("删除总警情表列表模板")
    @DeleteMapping("/clean")
    public String delete(String time){
        LambdaQueryWrapper<TblZongjq> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(TblZongjq::getTime, time);
        tblZongjqService.remove(queryWrapper);
        return "已删除";
    }
}
