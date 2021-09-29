package org.jeecg.modules.agent.orderform.service.impl;

import org.jeecg.modules.agent.orderform.entity.SalOdrd;
import org.jeecg.modules.agent.orderform.mapper.SalOdrdMapper;
import org.jeecg.modules.agent.orderform.service.ISalOdrdService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: sal_odrd
 * @Author: jeecg-boot
 * @Date:   2021-09-29
 * @Version: V1.0
 */
@Service
public class SalOdrdServiceImpl extends ServiceImpl<SalOdrdMapper, SalOdrd> implements ISalOdrdService {
	
	@Autowired
	private SalOdrdMapper salOdrdMapper;
	
	@Override
	public List<SalOdrd> selectByMainId(String mainId) {
		return salOdrdMapper.selectByMainId(mainId);
	}
}
