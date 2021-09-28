package org.jeecg.modules.demo.agent.service;

import java.util.List;
import java.util.Map;

import org.jeecg.modules.demo.agent.entity.VieRSBorderMode;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 围边表
 * @Author: Ning
 * @Date: 2021/09/23
 * @Version: V1.0
 */
public interface IVieRSBorderModeService extends IService<VieRSBorderMode> {
    public List<Map<String, Object>> queryVieRSBorderModeMap();
}
