package com.agriculture.youcai.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FindByGuestIdAndPdateWithCategoryVO {

    private String categoryCode;

    private String categoryName;

    @JsonProperty("products")
    private List<FindByGuestIdAndPdateVO> findByGuestIdAndPdateVOS;
}
