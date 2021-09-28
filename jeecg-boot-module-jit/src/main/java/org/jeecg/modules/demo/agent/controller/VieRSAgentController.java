package org.jeecg.modules.demo.agent.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.agent.entity.VieRSAgent;
import org.jeecg.modules.demo.agent.service.IVieRSAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: TODO
 * @author: Ning
 * @date: 2021/09/23
 * @Version: V1.0
 */
@Api(tags = "代理商订单表")
@RestController
@RequestMapping("/agent/vieRSAgent")
@Slf4j
public class VieRSAgentController extends JeecgController<VieRSAgent, IVieRSAgentService> {
    @Autowired
    private IVieRSAgentService vieRSAgentService;

    /**
     * 分页列表查询
     *
     * @param vieRSAgent
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @AutoLog(value = "代理商订单表-分页列表查询")
    @ApiOperation(value = "代理商订单表-分页列表查询", notes = "代理商订单表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<?> queryPageList(VieRSAgent vieRSAgent,
        @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize, HttpServletRequest req) {
        Page<VieRSAgent> page = new Page<VieRSAgent>(pageNo, pageSize);
        vieRSAgent.setFAgentCode(req.getParameter("fagentCode"));
        vieRSAgent.setFFullAgentName(req.getParameter("ffullAgentName"));
        page = vieRSAgentService.queryVieRSAgentPageList(page, vieRSAgent);
        return Result.OK(page);
    }

    /**
     * 添加
     *
     * @param vieRSAgent
     * @return
     */
    @AutoLog(value = "代理商订单表-添加")
    @ApiOperation(value = "代理商订单表-添加", notes = "代理商订单表-添加")
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody VieRSAgent vieRSAgent) {
        vieRSAgentService.save(vieRSAgent);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param vieRSAgent
     * @return
     */
    @AutoLog(value = "代理商订单表-编辑")
    @ApiOperation(value = "代理商订单表-编辑", notes = "代理商订单表-编辑")
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody VieRSAgent vieRSAgent) {
        vieRSAgentService.updateById(vieRSAgent);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "代理商订单表-通过id删除")
    @ApiOperation(value = "代理商订单表-通过id删除", notes = "代理商订单表-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        vieRSAgentService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "代理商订单表-批量删除")
    @ApiOperation(value = "代理商订单表-批量删除", notes = "代理商订单表-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.vieRSAgentService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @AutoLog(value = "代理商订单表-通过id查询")
    @ApiOperation(value = "代理商订单表-通过id查询", notes = "代理商订单表-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<?> queryById(@RequestParam(name = "id", required = true) String id) {
        VieRSAgent vieRSAgent = vieRSAgentService.getById(id);
        if (vieRSAgent == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(vieRSAgent);
    }
}
