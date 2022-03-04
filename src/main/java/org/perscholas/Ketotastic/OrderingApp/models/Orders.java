package org.perscholas.Ketotastic.OrderingApp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private Long deliveryId;
    private Long userId;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private Set<Item> item = new HashSet<>();

    public Orders() {
    }

    public Orders(Long id, String date, Long deliveryId, Long userId) {
        this.id = id;
        this.date = date;
        this.deliveryId = deliveryId;
        this.userId = userId;
    }

    // getters and setters, equals(), toString() .... (omitted for brevity)
}