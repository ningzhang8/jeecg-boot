package org.jeecg.modules.agent.orderform.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.agent.orderform.entity.SalOdrd;
import org.jeecg.modules.agent.orderform.entity.SalOdrm;

import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date: 2021-09-29
 * @Version: V1.0
 */
public interface ISalOdrmService extends IService<SalOdrm> {

    /**
     * 添加一对多
     * 
     */
    public void saveMain(SalOdrm salOdrm, List<SalOdrd> salOdrdList);

    /**
     * 修改一对多
     * 
     */
    public void updateMain(SalOdrm salOdrm, List<SalOdrd> salOdrdList);

    /**
     * 删除一对多
     */
    public void delMain(String id);

    /**
     * 批量删除一对多
     */
    public void delBatchMain(Collection<? extends Serializable> idList);

    /**
     * 获取快递数据
     */
    public List<Map<String, Object>> getExpressList();

    /**
     * 获取地区数据
     */
    public List<Map<String, Object>> getAddressTreeDataList(String keyLen, String value);

    /**
     * 查询过滤值
     */
    public List<Map<String, Object>> queryAddressListBySelectValue(String selectValue, String inputValue);

    /**
     * 根据当前登录用户获取代理商简称、业务员、币种
     */
    public Map<String, Object> getAgentUserByLoginUser(String userId);

    public Page<SalOdrm> getOrderMainListByLoginUser(Page<SalOdrm> page, String userId, HttpServletRequest req);

    public String getAgentByLoginUser(String userId);
}
