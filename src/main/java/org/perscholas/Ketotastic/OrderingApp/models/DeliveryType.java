package org.perscholas.Ketotastic.OrderingApp.models;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="Delivery_Type")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DeliveryType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull @Column(name = "delivery_type", unique = true, length = 45) @NotBlank
    String deliveryType;




}
