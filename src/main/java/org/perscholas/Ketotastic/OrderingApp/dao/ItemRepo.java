package org.perscholas.Ketotastic.OrderingApp.dao;

import org.perscholas.Ketotastic.OrderingApp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Item findItemByItemId(Long item_id);
}
