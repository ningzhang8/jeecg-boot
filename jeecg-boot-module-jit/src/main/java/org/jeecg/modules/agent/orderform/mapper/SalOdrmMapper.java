package org.jeecg.modules.agent.orderform.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.agent.orderform.entity.SalOdrm;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date: 2021-09-29
 * @Version: V1.0
 */
public interface SalOdrmMapper extends BaseMapper<SalOdrm> {
    public Page<SalOdrm> getOrderMainListByLoginUser(Page<SalOdrm> page, String userId);

    public List<Map<String, Object>> getExpressList();

    public List<Map<String, Object>> getAddressTreeDataList(String keyLen, String value);

    public List<Map<String, Object>> queryAddressListBySelectValue(String selectValue, String inputValue);

    public Map<String, Object> getAgentUserByLoginUser(String userId);

    public String getAgentByLoginUser(String userId);
}
