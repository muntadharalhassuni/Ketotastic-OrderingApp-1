package org.perscholas.Ketotastic.OrderingApp.dao;

import org.perscholas.Ketotastic.OrderingApp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}
