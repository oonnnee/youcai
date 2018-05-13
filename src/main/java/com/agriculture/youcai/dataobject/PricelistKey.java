package com.agriculture.youcai.dataobject;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * 联合主键：报价日期、报价客户id、报价产品id
 */
@Embeddable
@Data
public class PricelistKey implements Serializable {

    /*--- 报价日期 ---*/
    private Date pdate;

    /*--- 报价客户id ---*/
    private String guestId;

    /*--- 报价产品id ---*/
    private String productId;

}
