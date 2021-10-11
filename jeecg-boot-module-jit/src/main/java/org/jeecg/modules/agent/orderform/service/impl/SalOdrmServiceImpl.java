package org.jeecg.modules.agent.orderform.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.agent.orderform.entity.SalOdrd;
import org.jeecg.modules.agent.orderform.entity.SalOdrm;
import org.jeecg.modules.agent.orderform.mapper.SalOdrdMapper;
import org.jeecg.modules.agent.orderform.mapper.SalOdrmMapper;
import org.jeecg.modules.agent.orderform.service.ISalOdrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date: 2021-09-29
 * @Version: V1.0
 */
@Service
public class SalOdrmServiceImpl extends ServiceImpl<SalOdrmMapper, SalOdrm> implements ISalOdrmService {

    @Autowired
    private SalOdrmMapper salOdrmMapper;
    @Autowired
    private SalOdrdMapper salOdrdMapper;

    @Override
    @Transactional
    public void saveMain(SalOdrm salOdrm, List<SalOdrd> salOdrdList) {
        salOdrm.setFrecstat("0");
        salOdrm.setTxType("0");
        salOdrmMapper.insert(salOdrm);
        if (salOdrdList != null && salOdrdList.size() > 0) {
            for (SalOdrd entity : salOdrdList) {
                // 外键设置
                entity.setFkid(salOdrm.getId());
                salOdrdMapper.insert(entity);
            }
        }
    }

    @Override
    @Transactional
    public void updateMain(SalOdrm salOdrm, List<SalOdrd> salOdrdList) {
        salOdrmMapper.updateById(salOdrm);

        // 1.先删除子表数据
        salOdrdMapper.deleteByMainId(salOdrm.getId());

        // 2.子表数据重新插入
        if (salOdrdList != null && salOdrdList.size() > 0) {
            for (SalOdrd entity : salOdrdList) {
                // 外键设置
                entity.setFkid(salOdrm.getId());
                salOdrdMapper.insert(entity);
            }
        }
    }

    @Override
    @Transactional
    public void delMain(String id) {
        salOdrdMapper.deleteByMainId(id);
        salOdrmMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void delBatchMain(Collection<? extends Serializable> idList) {
        for (Serializable id : idList) {
            salOdrdMapper.deleteByMainId(id.toString());
            salOdrmMapper.deleteById(id);
        }
    }

    public Page<SalOdrm> getOrderMainListByLoginUser(Page<SalOdrm> page, String userId, HttpServletRequest req){
        HashMap<String, Object> map = new HashMap<>();
        map.put("orderDate_begin", req.getParameter("orderDate_begin"));
        map.put("orderDate_end", req.getParameter("orderDate_end"));
        map.put("sellDate_begin", req.getParameter("sellDate_begin"));
        map.put("sellDate_end", req.getParameter("sellDate_end"));
        return salOdrmMapper.getOrderMainListByLoginUser(page, userId);
    }

    @Override
    public List<Map<String, Object>> getExpressList() {
        return salOdrmMapper.getExpressList();
    }

    @Override
    public List<Map<String, Object>> getAddressTreeDataList(String keyLen, String value) {
        return salOdrmMapper.getAddressTreeDataList(keyLen, value);
    }

    @Override
    public List<Map<String, Object>> queryAddressListBySelectValue(String selectValue, String inputValue) {
        return salOdrmMapper.queryAddressListBySelectValue(selectValue, inputValue);
    }

    @Override
    public Map<String, Object> getAgentUserByLoginUser(String userId) {
        return salOdrmMapper.getAgentUserByLoginUser(userId);
    }

    @Override
    public String getAgentByLoginUser(String userId) {
        return salOdrmMapper.getAgentByLoginUser(userId);
    };

}
