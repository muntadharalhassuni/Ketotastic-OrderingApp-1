package org.perscholas.Ketotastic.OrderingApp.models;

import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "date", unique = true, length = 45) @NotBlank
    private String date;

    @Column(name = "delivery_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    //@ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    //private Set<Item> item = new HashSet<>();

    public Orders() {
    }

    public Orders(Long id, String date, Long deliveryId, Long userId) {
        this.id = id;
        this.date = date;
        this.deliveryId = deliveryId;
        this.userId = userId;
    }


}