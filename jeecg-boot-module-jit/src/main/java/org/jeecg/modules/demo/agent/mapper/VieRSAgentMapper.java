package org.jeecg.modules.demo.agent.mapper;

import java.util.List;

import org.jeecg.modules.demo.agent.entity.VieRSAgent;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Description: 代理商订单表
 * @author: Ning
 * @date: 2021/09/23
 * @Version: V1.0
 */
public interface VieRSAgentMapper extends BaseMapper<VieRSAgent> {
    List<VieRSAgent> queryVieRSAgentPageList(Page<VieRSAgent> page, VieRSAgent vieRSAgent);
}
