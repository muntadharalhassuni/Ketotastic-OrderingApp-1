package org.perscholas.Ketotastic.OrderingApp;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.Ketotastic.OrderingApp.dao.ItemRepo;
import org.perscholas.Ketotastic.OrderingApp.dao.RoleRepo;
import org.perscholas.Ketotastic.OrderingApp.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Log
@Transactional
public class AppStartupRunner implements CommandLineRunner {

    UserRepo userRepo;
    RoleRepo roleRepo;
    ItemRepo itemRepo;

    @Autowired
    public AppStartupRunner(UserRepo userRepo, RoleRepo roleRepo, ItemRepo foodItemRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.itemRepo=foodItemRepo;
    }

    @Override
    public void run(String... args) throws Exception {




    }

}

