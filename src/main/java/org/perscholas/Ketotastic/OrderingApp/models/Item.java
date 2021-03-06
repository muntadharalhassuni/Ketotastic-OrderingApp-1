package org.perscholas.Ketotastic.OrderingApp.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="item")
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Item implements Serializable {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemId;

    @NonNull @Column(name = "item_name", unique = true, length = 45) @NotBlank
    String itemName;

    @NonNull @Column(name = "item_description", unique = false, length = 200) @NotBlank
    String itemDescription;

    @NonNull @Column(name = "item_price", unique = false)
    @DecimalMin(value = "0.00", message = "Price has to be non negative number")
    BigDecimal itemPrice;


    public Item() {
    }

    public Item(String itemName, String itemDescription, BigDecimal itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

}
