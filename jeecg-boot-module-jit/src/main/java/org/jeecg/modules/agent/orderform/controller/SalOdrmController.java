package org.jeecg.modules.agent.orderform.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.agent.orderform.entity.SalOdrd;
import org.jeecg.modules.agent.orderform.entity.SalOdrm;
import org.jeecg.modules.agent.orderform.service.ISalOdrdService;
import org.jeecg.modules.agent.orderform.service.ISalOdrmService;
import org.jeecg.modules.agent.orderform.vo.SalOdrmPage;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date: 2021-09-29
 * @Version: V1.0
 */
@Api(tags = "订单表")
@RestController
@RequestMapping("/orderform/salOdrm")
@Slf4j
public class SalOdrmController {
    @Autowired
    private ISalOdrmService salOdrmService;
    @Autowired
    private ISalOdrdService salOdrdService;

    /**
     * 分页列表查询
     *
     * @param salOdrm
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @AutoLog(value = "订单表-分页列表查询")
    @ApiOperation(value = "订单表-分页列表查询", notes = "订单表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<?> queryPageList(SalOdrm salOdrm, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize, HttpServletRequest req) {
        QueryWrapper<SalOdrm> queryWrapper = QueryGenerator.initQueryWrapper(salOdrm, req.getParameterMap());
        Page<SalOdrm> page = new Page<SalOdrm>(pageNo, pageSize);
        IPage<SalOdrm> pageList = salOdrmService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param salOdrmPage
     * @return
     */
    @AutoLog(value = "订单表-添加")
    @ApiOperation(value = "订单表-添加", notes = "订单表-添加")
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody SalOdrmPage salOdrmPage) {
        SalOdrm salOdrm = new SalOdrm();
        BeanUtils.copyProperties(salOdrmPage, salOdrm);
        salOdrmService.saveMain(salOdrm, salOdrmPage.getSalOdrdList());
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param salOdrmPage
     * @return
     */
    @AutoLog(value = "订单表-编辑")
    @ApiOperation(value = "订单表-编辑", notes = "订单表-编辑")
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody SalOdrmPage salOdrmPage) {
        SalOdrm salOdrm = new SalOdrm();
        BeanUtils.copyProperties(salOdrmPage, salOdrm);
        SalOdrm salOdrmEntity = salOdrmService.getById(salOdrm.getId());
        if (salOdrmEntity == null) {
            return Result.error("未找到对应数据");
        }
        salOdrmService.updateMain(salOdrm, salOdrmPage.getSalOdrdList());
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "订单表-通过id删除")
    @ApiOperation(value = "订单表-通过id删除", notes = "订单表-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        salOdrmService.delMain(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "订单表-批量删除")
    @ApiOperation(value = "订单表-批量删除", notes = "订单表-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.salOdrmService.delBatchMain(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功！");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @AutoLog(value = "订单表-通过id查询")
    @ApiOperation(value = "订单表-通过id查询", notes = "订单表-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<?> queryById(@RequestParam(name = "id", required = true) String id) {
        SalOdrm salOdrm = salOdrmService.getById(id);
        if (salOdrm == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(salOdrm);

    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @AutoLog(value = "sal_odrd通过主表ID查询")
    @ApiOperation(value = "sal_odrd主表ID查询", notes = "sal_odrd-通主表ID查询")
    @GetMapping(value = "/querySalOdrdByMainId")
    public Result<?> querySalOdrdListByMainId(@RequestParam(name = "id", required = true) String id) {
        List<SalOdrd> salOdrdList = salOdrdService.selectByMainId(id);
        return Result.OK(salOdrdList);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param salOdrm
     */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, SalOdrm salOdrm) {
        // Step.1 组装查询条件查询数据
        QueryWrapper<SalOdrm> queryWrapper = QueryGenerator.initQueryWrapper(salOdrm, request.getParameterMap());
        LoginUser sysUser = (LoginUser)SecurityUtils.getSubject().getPrincipal();

        // Step.2 获取导出数据
        List<SalOdrm> queryList = salOdrmService.list(queryWrapper);
        // 过滤选中数据
        String selections = request.getParameter("selections");
        List<SalOdrm> salOdrmList = new ArrayList<SalOdrm>();
        if (oConvertUtils.isEmpty(selections)) {
            salOdrmList = queryList;
        } else {
            List<String> selectionList = Arrays.asList(selections.split(","));
            salOdrmList =
                queryList.stream().filter(item -> selectionList.contains(item.getId())).collect(Collectors.toList());
        }

        // Step.3 组装pageList
        List<SalOdrmPage> pageList = new ArrayList<SalOdrmPage>();
        for (SalOdrm main : salOdrmList) {
            SalOdrmPage vo = new SalOdrmPage();
            BeanUtils.copyProperties(main, vo);
            List<SalOdrd> salOdrdList = salOdrdService.selectByMainId(main.getId());
            vo.setSalOdrdList(salOdrdList);
            pageList.add(vo);
        }

        // Step.4 AutoPoi 导出Excel
        ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
        mv.addObject(NormalExcelConstants.FILE_NAME, "订单表列表");
        mv.addObject(NormalExcelConstants.CLASS, SalOdrmPage.class);
        mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("订单表数据", "导出人:" + sysUser.getRealname(), "订单表"));
        mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
        return mv;
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile file = entity.getValue();// 获取上传文件对象
            ImportParams params = new ImportParams();
            params.setTitleRows(2);
            params.setHeadRows(1);
            params.setNeedSave(true);
            try {
                List<SalOdrmPage> list = ExcelImportUtil.importExcel(file.getInputStream(), SalOdrmPage.class, params);
                for (SalOdrmPage page : list) {
                    SalOdrm po = new SalOdrm();
                    BeanUtils.copyProperties(page, po);
                    salOdrmService.saveMain(po, page.getSalOdrdList());
                }
                return Result.OK("文件导入成功！数据行数:" + list.size());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return Result.error("文件导入失败:" + e.getMessage());
            } finally {
                try {
                    file.getInputStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Result.OK("文件导入失败！");
    }

    /**
     * @description 订单表——获取快递数据
     * @author Ning
     * @date 2021/9/30
     * @return org.jeecg.common.api.vo.Result<?>
     */
    @GetMapping(value = "/getExpressList")
    public Result<?> getExpressList() {
        return Result.OK(salOdrmService.getExpressList());
    }

    /**
     * @description 订单表——获取地区数据
     * @author Ning
     * @date 2021/10/6
     * @return org.jeecg.common.api.vo.Result<?>
     */
    @GetMapping(value = "/getRegionList")
    public Result<?> getRegionList() {
        return Result.OK(salOdrmService.getRegionList());
    }

    /**
     * @description 订单表明细——获取围边数据
     * @author Ning
     * @date 2021/9/30
     * @return org.jeecg.common.api.vo.Result<?>
     */
    @GetMapping(value = "/getBorderModeList")
    public Result<?> getBorderModeList() {
        return Result.OK(salOdrdService.getBorderModeList());
    }
}
