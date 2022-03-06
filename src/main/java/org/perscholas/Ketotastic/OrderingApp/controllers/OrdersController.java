package org.perscholas.Ketotastic.OrderingApp.controllers;
import org.perscholas.Ketotastic.OrderingApp.dao.OrdersRepo;
import org.perscholas.Ketotastic.OrderingApp.models.Item;
import org.perscholas.Ketotastic.OrderingApp.models.Orders;
import org.perscholas.Ketotastic.OrderingApp.models.User;
import org.perscholas.Ketotastic.OrderingApp.services.ItemOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    OrdersRepo ordersRepo;
    @GetMapping("/orders")
    public String menu(Model model, @Valid User user){
        List<Orders> ordersList = ordersRepo.findByUserId(user.getUserId());
        model.addAttribute("ordersList", ordersList);
        return "orders";
    }
}
