package org.jeecg.modules.demo.agent.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 代理商订单表
 * @author: Ning
 * @date: 2021/09/23
 */
@Data
@TableName("Vie_RS_Agent")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Vie_RS_Agent对象", description = "代理商订单表")
public class VieRSAgent implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String fPkId;
    /** 订单编号 */
    @ApiModelProperty(value = "订单编号")
    private java.lang.String fAgentCode;
    /** 订单用户 */
    @ApiModelProperty(value = "订单用户")
    private java.lang.String fAgentName;
    /** 代理商简称 */
    @ApiModelProperty(value = "代理商简称")
    private java.lang.String fFullAgentName;
    /** 币别 */
    @ApiModelProperty(value = "币别")
    private java.lang.String fCurrency;
    /** 省份 */
    @ApiModelProperty(value = "省份")
    private java.lang.String fProvince;
    /** 市 */
    @ApiModelProperty(value = "市")
    private java.lang.String fCity;
    /** 地区 */
    @ApiModelProperty(value = "地区")
    private java.lang.String fDistrict;
    /** 业务员 */
    @ApiModelProperty(value = "业务员")
    private java.lang.String fSalesman;
}
