package com.sami.supershop.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class OrderItem extends BaseEntity {
    private Float quantity;
    private Float amount;
    private Date date;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    private Basket basket;
}
