package com.agriculture.youcai.dataobject;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * 客户采购单
 */
@Entity
@Data
public class Order {

    /*--- 联合主键：采购时间、采购客户id、采购产品id ---*/
    @EmbeddedId
    private OrderKey id;

    private BigDecimal price;

    private BigDecimal num;

    private BigDecimal amount;

    private String note;
}
