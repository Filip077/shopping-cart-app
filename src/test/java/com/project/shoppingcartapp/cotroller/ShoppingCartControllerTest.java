package com.project.shoppingcartapp.cotroller;

import com.project.shoppingcartapp.controller.ShoppingCartController;
import com.project.shoppingcartapp.enitity.Product;
import com.project.shoppingcartapp.enitity.ShoppingCart;
import com.project.shoppingcartapp.service.ProductManagementService;
import com.project.shoppingcartapp.service.ShoppingCartManagementService;
import com.project.shoppingcartapp.state.ShoppingCartEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartControllerTest {


    @Mock
    ShoppingCartManagementService shoppingCartManagementService;

    @InjectMocks
    ShoppingCartController shoppingCartController;

    MockMvc mockMvc;

    ShoppingCart shoppingCart;

    List<Product> productList;

    @BeforeEach
    void setUp() {

        productList = new ArrayList<>();
        shoppingCart = new ShoppingCart();
        Product product = new Product();

        shoppingCart.setId(1L);
        shoppingCart.setQuantity(1L);
        shoppingCart.setState(ShoppingCartEnum.OPEN);
        shoppingCart.setSerialNumber("ShoppingCartTest");


        product.setId(1L);
        product.setPrice(20L);
        product.setName("Product1");
        product.setSerialNumber("Test-Product1");
        product.setShoppingCart(shoppingCart);

        productList.add(product);
        shoppingCart.setProducts(productList);

        mockMvc = MockMvcBuilders
                .standaloneSetup(shoppingCartController)
                .build();

    }

    @Test
    void testGetAllProducts() throws Exception {
        when(shoppingCartManagementService.getAllProductsByShoppingCart("ShoppingCartTest")).thenReturn(shoppingCart.getProducts().subList(0, 1));

        mockMvc.perform(get("/api/shoppingCart/getShoppingCart/ShoppingCartTest"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));

    }
}
