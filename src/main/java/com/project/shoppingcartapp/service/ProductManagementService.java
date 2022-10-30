package com.project.shoppingcartapp.service;

import com.project.shoppingcartapp.enitity.Product;

import java.util.List;

public interface ProductManagementService {

    /**
     * Get all available products
     */
    List<Product> getAllProducts();
}
