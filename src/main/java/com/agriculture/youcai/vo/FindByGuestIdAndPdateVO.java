package com.agriculture.youcai.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FindByGuestIdAndPdateVO {

    private String productId;

    private String productName;

    private BigDecimal price;

    private String note;
}
