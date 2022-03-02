package org.perscholas.Ketotastic.OrderingApp.controllers;

import org.perscholas.Ketotastic.OrderingApp.services.ItemService;
import org.perscholas.Ketotastic.OrderingApp.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final ItemService itemService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ItemService itemService) {
        this.shoppingCartService = shoppingCartService;
        this.itemService = itemService;
    }

    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        modelAndView.addObject("items", shoppingCartService.getItemsInCart());
        modelAndView.addObject("total", shoppingCartService.getTotal().toString());
        return modelAndView;
    }

    @GetMapping("/shoppingCart/addItem/{itemId}")
    public ModelAndView addProductToCart(@PathVariable("itemId") Long itemId) {
        itemService.findById(itemId).ifPresent(shoppingCartService::addItem);
        return shoppingCart();
    }

    @GetMapping("/shoppingCart/removeItem/{itemId}")
    public ModelAndView removeProductFromCart(@PathVariable("itemId") Long itemId) {
        itemService.findById(itemId).ifPresent(shoppingCartService::removeItem);
        return shoppingCart();
    }

    @GetMapping("/confirmation")
    public ModelAndView confirmation() {
        ModelAndView modelAndView = new ModelAndView("/confirmation");
        modelAndView.addObject("items", shoppingCartService.getItemsInCart());
        modelAndView.addObject("total", shoppingCartService.getTotal().toString());


        return modelAndView;
    }
}
