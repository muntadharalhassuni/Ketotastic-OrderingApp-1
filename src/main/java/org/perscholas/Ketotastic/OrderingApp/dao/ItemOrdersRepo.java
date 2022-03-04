package org.perscholas.Ketotastic.OrderingApp.dao;
import org.perscholas.Ketotastic.OrderingApp.models.ItemOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemOrdersRepo extends JpaRepository <ItemOrders, Long> {
}
