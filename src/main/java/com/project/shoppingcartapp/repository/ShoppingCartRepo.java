package com.project.shoppingcartapp.repository;

import com.project.shoppingcartapp.enitity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {

    ShoppingCart findShoppingCartBySerialNumber(String serialNumber);
}
