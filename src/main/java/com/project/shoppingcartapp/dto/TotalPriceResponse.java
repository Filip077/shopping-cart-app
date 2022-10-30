package com.project.shoppingcartapp.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TotalPriceResponse {

    private final long totalPrice;
}
