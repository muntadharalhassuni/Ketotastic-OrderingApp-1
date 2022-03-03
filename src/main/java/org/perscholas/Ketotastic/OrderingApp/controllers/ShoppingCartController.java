package org.perscholas.Ketotastic.OrderingApp.controllers;

import org.perscholas.Ketotastic.OrderingApp.models.DeliveryType;
import org.perscholas.Ketotastic.OrderingApp.services.DeliveryTypeService;
import org.perscholas.Ketotastic.OrderingApp.services.ItemService;
import org.perscholas.Ketotastic.OrderingApp.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final ItemService itemService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ItemService itemService) {
        this.shoppingCartService = shoppingCartService;
        this.itemService = itemService;
    }
    @Autowired
    DeliveryTypeService deliveryTypeService;

    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        List<DeliveryType> deliverytypes = deliveryTypeService.listAll();
        modelAndView.addObject("deliverytypes",deliverytypes);
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
