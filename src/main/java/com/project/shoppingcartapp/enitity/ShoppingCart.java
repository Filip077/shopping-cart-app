package com.project.shoppingcartapp.enitity;

import com.project.shoppingcartapp.state.ShoppingCartEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SHOPPING_CART")
@Getter
@Setter
public class ShoppingCart extends BaseEntity {

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;
    @Column(name = "STATE", nullable = false)
    private ShoppingCartEnum state;
    @Column(name = "SERIAL_NUM", nullable = false)
    private String serialNumber;
    @OneToMany(mappedBy = "shoppingCart")
    private List<Product> products;
}
