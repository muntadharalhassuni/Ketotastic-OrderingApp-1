package org.perscholas.Ketotastic.OrderingApp.models;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name="Delivery_Type")
@NoArgsConstructor

public class DeliveryType {
    @Id
    private @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "delivery_type", unique = true, length = 45) @NotBlank
    private String deliveryType;

    public DeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
