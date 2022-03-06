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
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemOrders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemOrdersId;

   // @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long item_id;

//    //@Id
//    @Column(name = "user_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long userId;

    //@Id


//    @NonNull @Column(name = "item_price", unique = false)
//    @DecimalMin(value = "0.00", message = "Price has to be non negative number")
//    BigDecimal itemPrice;
//
//    //@Id
//    @Column(name = "delivery_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long deliveryId;



}
