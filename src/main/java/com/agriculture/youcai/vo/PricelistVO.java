package com.agriculture.youcai.vo;

import com.agriculture.youcai.dto.PricelistDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PricelistVO {

    private String guestId;

    private Date pdate;

    @JsonProperty("products")
    private List<PricelistDTO> pricelistDTOS;

}
