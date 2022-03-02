package org.perscholas.Ketotastic.OrderingApp.dao;

import org.perscholas.Ketotastic.OrderingApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
