package com.cy.feeManagement.FeeWater.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cy.valid.feeAddOrEdit;
import com.cy.valid.feePay;
import com.cy.valid.listValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cy
 * @program: WuYeManagementProgram_java
 * @description: 水费
 * @date 2022-01-21 14:14:00
 */
@Data
@TableName("fee_water")
public class FeeWater implements Serializable {
    @TableId(type = IdType.AUTO)
    @NotNull(groups = {feePay.class})
    private Long waterId;

    /**
     * 房屋id
     */
    @NotNull(groups = {feeAddOrEdit.class})
    private Long houseId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 所属月份
     */
    @NotBlank(groups = {feeAddOrEdit.class})
    private String payWaterMonth;

    /**
     * 缴费金额
     */
    @DecimalMin(value = "0")
    @NotNull(groups = {feeAddOrEdit.class})
    private BigDecimal payWaterMoney;

    /**
     * 表显
     */
    @NotBlank(groups = {feeAddOrEdit.class})
    private String waterNum;

    /**
     *  缴费状态
     */
    @listValue(values = {"0","1"})
    @NotBlank(groups = {feePay.class,feeAddOrEdit.class})
    private String payWaterStatus;

    /**
     * 缴费时间
     */

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date payWaterTime;

    /**
     * 业主名字
     */
    @TableField(exist = false)
    private String userName;

    /**
     * 业主手机号
     */
    @TableField(exist = false)
    private String phone;

    /**
     * 单元名字
     */
    @TableField(exist = false)
    private String unitName;

    /**
     * 房屋编号
     */
    @TableField(exist = false)
    private String houseNum;

    /**
     * 栋数名字
     */
    @TableField(exist = false)
    private String buildName;

    /**
     * 栋数id
     */
    @TableField(exist = false)
    private Long buildId;

    /**
     * 单端id
     */
    @TableField(exist = false)
    private Long unitId;
}
