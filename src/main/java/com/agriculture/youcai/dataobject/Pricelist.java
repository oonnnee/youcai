package com.agriculture.youcai.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户报价单
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pricelist {

    /*--- 联合主键：报价日期、报价客户id、报价产品id ---*/
    @EmbeddedId
    private PricelistKey id;

    /*--- 报价产品价格 ---*/
    private BigDecimal price;

    private String note;

}
