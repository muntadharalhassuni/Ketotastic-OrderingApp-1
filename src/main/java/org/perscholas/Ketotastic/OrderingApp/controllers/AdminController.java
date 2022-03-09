package org.perscholas.Ketotastic.OrderingApp.controllers;

import org.perscholas.Ketotastic.OrderingApp.models.Item;
import org.perscholas.Ketotastic.OrderingApp.models.User;
import org.perscholas.Ketotastic.OrderingApp.services.ItemService;
import org.perscholas.Ketotastic.OrderingApp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")

@RequestMapping("console")
public class AdminController {



    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    //Manage Users

    //to show the user list
    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> userList=userService.listAll();
        model.addAttribute("users", userList);
        return "users";
    }

    //to delete any user from the user list
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/console/users";
    }

    //Manage items
    //to show food item list to the admin
    @GetMapping("/itemlist")
    public String viewFoodItem(Model model) {
        List<Item> items = itemService.listAll();
        model.addAttribute("items", items);
        return "item_list";
    }

    //adding new food item
    @GetMapping("/newitem")
    public String showNewFoodItem(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "new_item";
    }

    //confirming new food item is being added
    @PostMapping(value = "/item_added")
    public String saveItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "item_added";
    }


    //to update any food item on the list
    @GetMapping("/updateItem/{id}")
    public String updateItem(@PathVariable(value = "id") long id, Model model) {
        Item item=itemService.getItemById(id);
        model.addAttribute("item", item);
        return "update_item";
    }

    //to delete any food item on the list
    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable (value = "id") long id) {
        this.itemService.deleteItemById(id);
        return "redirect:/console/itemlist";
    }
//LOG.debug("error field = " + error.getField() + " message = " + error.getDefaultMessage());
}
