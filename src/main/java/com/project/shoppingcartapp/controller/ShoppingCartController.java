package com.project.shoppingcartapp.controller;

import com.project.shoppingcartapp.dto.AddProductResponse;
import com.project.shoppingcartapp.dto.ShoppingCartProductsResponse;
import com.project.shoppingcartapp.dto.TotalPriceResponse;
import com.project.shoppingcartapp.enitity.Product;
import com.project.shoppingcartapp.repository.ShoppingCartRepo;
import com.project.shoppingcartapp.service.ShoppingCartManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingCart/")
@AllArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartManagementService shoppingCartManagementService;
    private final ShoppingCartRepo shoppingCartRepo;

    @PutMapping("/addProduct/{productSerialNumber}")
    public ResponseEntity<AddProductResponse> addProduct(@PathVariable(name = "productSerialNumber") String productSerialNumber) {
        return new ResponseEntity<>(AddProductResponse.builder()
                .shoppingCart(shoppingCartManagementService.addProduct(productSerialNumber)).build(), HttpStatus.CREATED);
    }

    @GetMapping("/getShoppingCart/{shoppingCartSerialNum}")
    public ResponseEntity<ShoppingCartProductsResponse> getShoppingCartProducts(@PathVariable(name = "shoppingCartSerialNum") String shoppingCartSerialNum){
      return new ResponseEntity<>(ShoppingCartProductsResponse.builder()
              .products(shoppingCartManagementService.getAllProductsByShoppingCart(shoppingCartSerialNum)).build(), HttpStatus.OK);
    }

    @GetMapping("/{shoppingCartSerialNum}/totalPrice")
    public ResponseEntity<TotalPriceResponse> getTotalPrice(@PathVariable(name = "shoppingCartSerialNum") String shoppingCartSerialNum){
        long totalPrice = 0L;
        List<Product> products = shoppingCartRepo.findShoppingCartBySerialNumber(shoppingCartSerialNum).getProducts();

        for (Product p : products){
            totalPrice += p.getPrice();
        }
        return new ResponseEntity<>(TotalPriceResponse.builder().totalPrice(totalPrice).build(), HttpStatus.OK);
    }
}
