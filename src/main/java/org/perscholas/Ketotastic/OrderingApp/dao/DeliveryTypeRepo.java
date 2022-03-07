package org.perscholas.Ketotastic.OrderingApp.dao;
import org.perscholas.Ketotastic.OrderingApp.models.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTypeRepo extends JpaRepository<DeliveryType, Long>  {

}
