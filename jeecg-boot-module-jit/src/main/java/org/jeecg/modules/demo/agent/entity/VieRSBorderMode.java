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
 * @Description: 围边表
 * @author: Ning
 * @date: 2021/09/24
 */
@Data
@TableName("Vie_RS_BorderMode")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Vie_RS_BorderMode对象", description = "围边表")
public class VieRSBorderMode implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String fPkId;
    /** 围边方式 */
    @ApiModelProperty(value = "围边方式")
    private java.lang.String fDesc;
    /** sortId */
    @ApiModelProperty(value = "sortId")
    private java.lang.String fSortid;
}
