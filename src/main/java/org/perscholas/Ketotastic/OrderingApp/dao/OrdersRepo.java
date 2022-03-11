package org.perscholas.Ketotastic.OrderingApp.dao;


import org.hibernate.criterion.Order;
import org.perscholas.Ketotastic.OrderingApp.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders, Long> {



    List<Orders> findByDate(String date);
    List<Orders> findByUserId(Long userId);




}