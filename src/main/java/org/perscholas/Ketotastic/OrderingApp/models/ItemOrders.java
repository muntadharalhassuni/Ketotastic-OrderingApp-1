package org.perscholas.Ketotastic.OrderingApp.models;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;


@Entity
@Data
@Table(name="item_orders")

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemOrders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemOrdersId;


    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long item_id;





}
