package org.jeecg.modules.agent.orderform.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: sal_odrd
 * @Author: jeecg-boot
 * @Date:   2021-09-29
 * @Version: V1.0
 */
@ApiModel(value="sal_odrd对象", description="sal_odrd")
@Data
@TableName("sal_odrd")
public class SalOdrd implements Serializable {
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
	/**fkid*/
    @ApiModelProperty(value = "fkid")
    private java.lang.String fkid;
	/**fproductdesc*/
	@Excel(name = "fproductdesc", width = 15)
    @ApiModelProperty(value = "fproductdesc")
    private java.lang.String fproductdesc;
	/**len*/
	@Excel(name = "len", width = 15)
    @ApiModelProperty(value = "len")
    private java.math.BigDecimal len;
	/**width*/
	@Excel(name = "width", width = 15)
    @ApiModelProperty(value = "width")
    private java.math.BigDecimal width;
	/**quality*/
	@Excel(name = "quality", width = 15)
    @ApiModelProperty(value = "quality")
    private java.math.BigDecimal quality;
	/**area*/
	@Excel(name = "area", width = 15)
    @ApiModelProperty(value = "area")
    private java.math.BigDecimal area;
	/**price*/
	@Excel(name = "price", width = 15)
    @ApiModelProperty(value = "price")
    private java.math.BigDecimal price;
	/**total*/
	@Excel(name = "total", width = 15)
    @ApiModelProperty(value = "total")
    private java.math.BigDecimal total;
	/**color*/
	@Excel(name = "color", width = 15)
    @ApiModelProperty(value = "color")
    private java.lang.String color;
	/**logoColor*/
	@Excel(name = "logoColor", width = 15)
    @ApiModelProperty(value = "logoColor")
    private java.lang.String logoColor;
	/**borderMode*/
	@Excel(name = "borderMode", width = 15)
    @ApiModelProperty(value = "borderMode")
    private java.lang.String borderMode;
	/**otherReq*/
	@Excel(name = "otherReq", width = 15)
    @ApiModelProperty(value = "otherReq")
    private java.lang.String otherReq;
	/**fproductcode*/
	@Excel(name = "fproductcode", width = 15)
    @ApiModelProperty(value = "fproductcode")
    private java.lang.String fproductcode;
	/**fsubclacode*/
	@Excel(name = "fsubclacode", width = 15)
    @ApiModelProperty(value = "fsubclacode")
    private java.lang.String fsubclacode;
	/**unitPrice*/
	@Excel(name = "unitPrice", width = 15)
    @ApiModelProperty(value = "unitPrice")
    private java.math.BigDecimal unitPrice;
	/**fpriceid*/
	@Excel(name = "fpriceid", width = 15)
    @ApiModelProperty(value = "fpriceid")
    private java.lang.String fpriceid;
	/**fcategory*/
	@Excel(name = "fcategory", width = 15)
    @ApiModelProperty(value = "fcategory")
    private java.lang.String fcategory;
	/**fsubcategory*/
	@Excel(name = "fsubcategory", width = 15)
    @ApiModelProperty(value = "fsubcategory")
    private java.lang.String fsubcategory;
	/**imagePath*/
	@Excel(name = "imagePath", width = 15)
    @ApiModelProperty(value = "imagePath")
    private java.lang.String imagePath;
}
