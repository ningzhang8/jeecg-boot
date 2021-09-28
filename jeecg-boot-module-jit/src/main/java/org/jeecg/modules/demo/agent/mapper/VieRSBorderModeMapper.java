package org.jeecg.modules.demo.agent.mapper;

import java.util.List;
import java.util.Map;

import org.jeecg.modules.demo.agent.entity.VieRSBorderMode;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 围边表
 * @author: Ning
 * @date: 2021/09/23
 * @Version: V1.0
 */
public interface VieRSBorderModeMapper extends BaseMapper<VieRSBorderMode> {
    List<Map<String, Object>> queryVieRSBorderModeMap();
}
