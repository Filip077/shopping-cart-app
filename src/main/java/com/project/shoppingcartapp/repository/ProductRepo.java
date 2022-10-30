package com.project.shoppingcartapp.repository;

import com.project.shoppingcartapp.enitity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findProductBySerialNumber(String serialNumber);
}
