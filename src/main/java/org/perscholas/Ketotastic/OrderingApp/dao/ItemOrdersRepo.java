package org.perscholas.Ketotastic.OrderingApp.dao;
import org.perscholas.Ketotastic.OrderingApp.models.ItemOrders;
import org.perscholas.Ketotastic.OrderingApp.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrdersRepo extends JpaRepository <ItemOrders, Long> {
    //List<Orders> findByDate(String date);
}
