package org.jeecg.modules.agent.orderform.service;

import org.jeecg.modules.agent.orderform.entity.SalOdrd;
import org.jeecg.modules.agent.orderform.entity.SalOdrm;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2021-09-29
 * @Version: V1.0
 */
public interface ISalOdrmService extends IService<SalOdrm> {

	/**
	 * 添加一对多
	 * 
	 */
	public void saveMain(SalOdrm salOdrm,List<SalOdrd> salOdrdList) ;
	
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(SalOdrm salOdrm,List<SalOdrd> salOdrdList);
	
	/**
	 * 删除一对多
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
