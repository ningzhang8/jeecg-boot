package org.jeecg.modules.demo.agent.service.impl;

import javax.annotation.Resource;

import org.jeecg.modules.demo.agent.entity.VieRSAgent;
import org.jeecg.modules.demo.agent.mapper.VieRSAgentMapper;
import org.jeecg.modules.demo.agent.service.IVieRSAgentService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 代理商订单表
 * @author: Ning
 * @date: 2021/09/23
 * @Version: V1.0
 */
@Service
public class VieRSAgentServiceImpl extends ServiceImpl<VieRSAgentMapper, VieRSAgent> implements IVieRSAgentService {

    @Resource
    private VieRSAgentMapper vieRSAgentMapper;

    @Override
    public Page<VieRSAgent> queryVieRSAgentPageList(Page<VieRSAgent> page, VieRSAgent vieRSAgent) {
        return page.setRecords(vieRSAgentMapper.queryVieRSAgentPageList(page, vieRSAgent));
    }
}
