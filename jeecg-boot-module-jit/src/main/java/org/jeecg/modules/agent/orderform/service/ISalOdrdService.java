package org.jeecg.modules.agent.orderform.service;

import java.util.List;
import java.util.Map;

import org.jeecg.modules.agent.orderform.entity.SalOdrd;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: sal_odrd
 * @Author: jeecg-boot
 * @Date: 2021-09-29
 * @Version: V1.0
 */
public interface ISalOdrdService extends IService<SalOdrd> {

    public List<SalOdrd> selectByMainId(String mainId);

    /**
     * 获取围边数据
     */
    public List<Map<String, Object>> getBorderModeList();
}
