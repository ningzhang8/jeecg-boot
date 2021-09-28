package org.jeecg.modules.demo.agent.service;

import org.jeecg.modules.demo.agent.entity.VieRSAgent;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 代理商订单表
 * @Author: Ning
 * @Date: 2021/09/23
 * @Version: V1.0
 */
public interface IVieRSAgentService extends IService<VieRSAgent> {
    public Page<VieRSAgent> queryVieRSAgentPageList(Page<VieRSAgent> page, VieRSAgent vieRSAgent);
}
