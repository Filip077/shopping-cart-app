package com.project.shoppingcartapp.controller;

import com.project.shoppingcartapp.dto.GetAllProductsResponse;
import com.project.shoppingcartapp.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/products/")
@AllArgsConstructor
public class ProductsController {

    private final ProductRepo productRepo;

    @GetMapping("/getProducts")
    public ResponseEntity<GetAllProductsResponse> getProducts() {
        return new ResponseEntity<>(GetAllProductsResponse.builder().products(productRepo.findAll()).build(), HttpStatus.OK);
    }
}
