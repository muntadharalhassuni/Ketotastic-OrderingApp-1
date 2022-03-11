package org.perscholas.Ketotastic.OrderingApp.dao;

import org.perscholas.Ketotastic.OrderingApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = :username")
    public User findByUsername(@Param("username") String username);


}
