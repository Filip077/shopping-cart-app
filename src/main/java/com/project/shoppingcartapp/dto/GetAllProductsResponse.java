package com.project.shoppingcartapp.dto;

import com.project.shoppingcartapp.enitity.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GetAllProductsResponse {
    private List<Product> products;
}
