package com.project.shoppingcartapp.service;

import com.project.shoppingcartapp.enitity.Product;
import com.project.shoppingcartapp.enitity.ShoppingCart;
import com.project.shoppingcartapp.exception.NoDataFoundException;
import com.project.shoppingcartapp.repository.ProductRepo;
import com.project.shoppingcartapp.repository.ShoppingCartRepo;
import com.project.shoppingcartapp.state.ShoppingCartEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ShoppingCartManagementServiceImpl implements ShoppingCartManagementService{

    private final ShoppingCartRepo shoppingCartRepo;
    private final ProductRepo productRepo;

    @Override
    public List<Product> getAllProductsByShoppingCart(String serialNumber) {
       ShoppingCart shoppingCart = shoppingCartRepo.findShoppingCartBySerialNumber(serialNumber);
       if(Objects.isNull(shoppingCart)){
           throw new NoDataFoundException("The shopping cart does not exists.");
       }
       return shoppingCart.getProducts();
    }

    @Override
    public ShoppingCart addProduct(String productSerialNumber) {
        ShoppingCart shoppingCart;
        boolean shoppingCartExists = shoppingCartRepo.count() > 0;
        Product product = productRepo.findProductBySerialNumber(productSerialNumber);

        if (Objects.isNull(product)){
            throw new NoDataFoundException("The product required does not exits.");
        }

            if(shoppingCartExists) {
                shoppingCart = shoppingCartRepo.findAll().get(0);
                List<Product> shoppingCartProducts = shoppingCart.getProducts();

                product.setShoppingCart(shoppingCart);
                shoppingCartProducts.add(product);
                shoppingCart.setProducts(shoppingCartProducts);
                shoppingCart.setQuantity(shoppingCart.getQuantity()+1);
                shoppingCartRepo.save(shoppingCart);
            } else {
                shoppingCart = new ShoppingCart();
                List<Product> newProducts = new ArrayList<>();
                String cartSerialNumber = "SHPCRT1";

                newProducts.add(product);
                product.setShoppingCart(shoppingCart);
                shoppingCart.setProducts(newProducts);
                shoppingCart.setState(ShoppingCartEnum.OPEN);
                shoppingCart.setQuantity(1L);
                shoppingCart.setSerialNumber(cartSerialNumber);
                shoppingCartRepo.save(shoppingCart);
            }
        return shoppingCart;
    }
}
