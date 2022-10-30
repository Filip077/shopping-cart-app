package com.project.shoppingcartapp.service;

import com.project.shoppingcartapp.enitity.Product;
import com.project.shoppingcartapp.enitity.ShoppingCart;

import java.util.List;

public interface ShoppingCartManagementService {

    /**
     * Get shopping cart by serialNumber
     */
    List<Product> getAllProductsByShoppingCart(String serialNumber);
    /**
     * Add product to shopping cart
     */
    ShoppingCart addProduct(String productSerialNumber);
}
