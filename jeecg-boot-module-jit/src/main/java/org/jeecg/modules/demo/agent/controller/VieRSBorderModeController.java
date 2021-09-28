package org.jeecg.modules.demo.agent.controller;

import java.util.List;
import java.util.Map;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.agent.entity.VieRSBorderMode;
import org.jeecg.modules.demo.agent.service.IVieRSBorderModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: TODO
 * @author: Ning
 * @date: 2021/09/24
 */
@Api(tags = "围边表")
@RestController
@RequestMapping("/agent/vieRSBorderMode")
@Slf4j
public class VieRSBorderModeController extends JeecgController<VieRSBorderMode, IVieRSBorderModeService> {
    @Autowired
    private IVieRSBorderModeService vieRSBorderModeService;

    /**
     * 代理商订单表-订单明细-围边
     *
     * @return
     */
    @AutoLog(value = "代理商订单表-订单明细-围边")
    @ApiOperation(value = "代理商订单表-订单明细-围边", notes = "代理商订单表-订单明细-围边")
    @GetMapping(value = "/list")
    public Result<?> queryMap() {
        return Result.OK(vieRSBorderModeService.queryVieRSBorderModeMap());
    }
}
