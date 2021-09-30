package org.jeecg.modules.agent.orderform.mapper;

import java.util.List;
import java.util.Map;

import org.jeecg.modules.agent.orderform.entity.SalOdrd;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: sal_odrd
 * @Author: jeecg-boot
 * @Date: 2021-09-29
 * @Version: V1.0
 */
public interface SalOdrdMapper extends BaseMapper<SalOdrd> {

    public boolean deleteByMainId(@Param("mainId") String mainId);

    public List<SalOdrd> selectByMainId(@Param("mainId") String mainId);

    public List<Map<String, Object>> getBorderModeList();
}
