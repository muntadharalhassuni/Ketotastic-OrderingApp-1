package org.perscholas.Ketotastic.OrderingApp.controllers;

import org.perscholas.Ketotastic.OrderingApp.models.Item;
import org.perscholas.Ketotastic.OrderingApp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    //to show food item list to the customer
    @GetMapping("/menu")
    public String menu(Model model){
        List<Item> foodItems = itemService.listAll();
        model.addAttribute("foodItems", foodItems);
        return "menu";
    }
}
