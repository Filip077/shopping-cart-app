package com.project.shoppingcartapp.service;

import com.project.shoppingcartapp.enitity.Product;
import com.project.shoppingcartapp.repository.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductManagementServiceImpl implements ProductManagementService {

    private final ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
            return productRepo.findAll();
    }
}
