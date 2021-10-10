package org.jeecg.modules.agent.orderform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2021-09-29
 * @Version: V1.0
 */
@ApiModel(value="sal_odrm对象", description="订单表")
@Data
@TableName("sal_odrm")
public class SalOdrm implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**createBy*/
    @ApiModelProperty(value = "createBy")
    private java.lang.String createBy;
	/**createTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "createTime")
    private java.util.Date createTime;
	/**updateBy*/
    @ApiModelProperty(value = "updateBy")
    private java.lang.String updateBy;
	/**updateTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "updateTime")
    private java.util.Date updateTime;
	/**orderNumber*/
	@Excel(name = "orderNumber", width = 15)
    @ApiModelProperty(value = "orderNumber")
    private java.lang.String orderNumber;
	/**fkagentid*/
	@Excel(name = "fkagentid", width = 15)
    @ApiModelProperty(value = "fkagentid")
    private java.lang.String fkagentid;
	/**orderSource*/
	@Excel(name = "orderSource", width = 15)
    @ApiModelProperty(value = "orderSource")
    private java.lang.String orderSource;
	/**salesman*/
	@Excel(name = "salesman", width = 15)
    @ApiModelProperty(value = "salesman")
    private java.lang.String salesman;
	/**orderInfo*/
	@Excel(name = "orderInfo", width = 15)
    @ApiModelProperty(value = "orderInfo")
    private java.lang.String orderInfo;
	/**cnee*/
	@Excel(name = "cnee", width = 15)
    @ApiModelProperty(value = "cnee")
    private java.lang.String cnee;
	/**tel*/
	@Excel(name = "tel", width = 15)
    @ApiModelProperty(value = "tel")
    private java.lang.String tel;
	/**fullAddress*/
	@Excel(name = "fullAddress", width = 15)
    @ApiModelProperty(value = "fullAddress")
    private java.lang.String fullAddress;
	/**city*/
	@Excel(name = "city", width = 15)
    @ApiModelProperty(value = "city")
    private java.lang.String city;
	/**province*/
	@Excel(name = "province", width = 15)
    @ApiModelProperty(value = "province")
    private java.lang.String province;
	/**region*/
	@Excel(name = "region", width = 15)
    @ApiModelProperty(value = "region")
    private java.lang.String region;
	/**customerCode*/
	@Excel(name = "customerCode", width = 15)
    @ApiModelProperty(value = "customerCode")
    private java.lang.String customerCode;
	/**address*/
	@Excel(name = "address", width = 15)
    @ApiModelProperty(value = "address")
    private java.lang.String address;
	/**orderAmt*/
	@Excel(name = "orderAmt", width = 15)
    @ApiModelProperty(value = "orderAmt")
    private java.math.BigDecimal orderAmt;
	/**req*/
	@Excel(name = "req", width = 15)
    @ApiModelProperty(value = "req")
    private java.lang.String req;
	/**orderDate*/
	@Excel(name = "orderDate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "orderDate")
    private java.util.Date orderDate;
	/**txType*/
	@Excel(name = "txType", width = 15)
    @ApiModelProperty(value = "txType")
    private java.lang.String txType;
	/**sellDate*/
	@Excel(name = "sellDate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "sellDate")
    private java.util.Date sellDate;
	/**fcurrency*/
	@Excel(name = "fcurrency", width = 15)
    @ApiModelProperty(value = "fcurrency")
    private java.lang.String fcurrency;
	/**customerOrderNumber*/
	@Excel(name = "customerOrderNumber", width = 15)
    @ApiModelProperty(value = "customerOrderNumber")
    private java.lang.String customerOrderNumber;
	/**fkexpressid*/
	@Excel(name = "fkexpressid", width = 15)
    @ApiModelProperty(value = "fkexpressid")
    private java.lang.String fkexpressid;
	/**frecstat*/
	@Excel(name = "frecstat", width = 15)
    @ApiModelProperty(value = "frecstat")
    private java.lang.String frecstat;
	/**file1*/
	@Excel(name = "file1", width = 15)
    @ApiModelProperty(value = "file1")
    private java.lang.String file1;
	/**file2*/
	@Excel(name = "file2", width = 15)
    @ApiModelProperty(value = "file2")
    private java.lang.String file2;
}
