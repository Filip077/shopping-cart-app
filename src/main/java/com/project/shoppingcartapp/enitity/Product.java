package com.project.shoppingcartapp.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.shoppingcartapp.state.ShoppingCartEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseEntity {

    @Column(name = "PRICE", nullable = false)
    private Long price;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "SERIAL_NUM", nullable = false)
    private String serialNumber;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "SHOPPING_CART_ID", nullable=false)
    private ShoppingCart shoppingCart;
}
