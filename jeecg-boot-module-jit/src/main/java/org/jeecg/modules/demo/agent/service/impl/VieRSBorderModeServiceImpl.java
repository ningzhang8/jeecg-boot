package org.jeecg.modules.demo.agent.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecg.modules.demo.agent.entity.VieRSBorderMode;
import org.jeecg.modules.demo.agent.mapper.VieRSBorderModeMapper;
import org.jeecg.modules.demo.agent.service.IVieRSBorderModeService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 围边表
 * @author: Ning
 * @date: 2021/09/24
 */
@Service
public class VieRSBorderModeServiceImpl extends ServiceImpl<VieRSBorderModeMapper, VieRSBorderMode>
    implements IVieRSBorderModeService {

    @Resource
    private VieRSBorderModeMapper vieRSBorderModeMapper;

    @Override
    public List<Map<String, Object>> queryVieRSBorderModeMap() {
        return vieRSBorderModeMapper.queryVieRSBorderModeMap();
    }
}
