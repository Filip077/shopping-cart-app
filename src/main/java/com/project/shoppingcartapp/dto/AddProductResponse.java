package com.project.shoppingcartapp.dto;

import com.project.shoppingcartapp.enitity.ShoppingCart;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddProductResponse {
    private ShoppingCart shoppingCart;
}
