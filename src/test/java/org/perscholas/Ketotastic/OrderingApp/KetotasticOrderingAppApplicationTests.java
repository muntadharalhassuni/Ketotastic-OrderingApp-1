package org.perscholas.Ketotastic.OrderingApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.perscholas.Ketotastic.OrderingApp.dao.DeliveryTypeRepo;
import org.perscholas.Ketotastic.OrderingApp.dao.ItemRepo;
import org.perscholas.Ketotastic.OrderingApp.dao.OrdersRepo;
import org.perscholas.Ketotastic.OrderingApp.dao.RoleRepo;
import org.perscholas.Ketotastic.OrderingApp.models.DeliveryType;
import org.perscholas.Ketotastic.OrderingApp.models.Item;
import org.perscholas.Ketotastic.OrderingApp.models.Orders;
import org.perscholas.Ketotastic.OrderingApp.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
class KetotasticOrderingAppApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncoderTest(){
        String password = "perfectstudent";
        String encodedPassword = passwordEncoder.encode(password);
        Assertions.assertTrue(passwordEncoder.matches(password, encodedPassword));
    }

    @Autowired
    RoleRepo roleRepo;

    private Role role = new Role("AA");

    @Test
    public void saveRoleTest(){
        roleRepo.save(role);
        Assertions.assertNotNull(roleRepo.findByRole(role.getRole()));
        roleRepo.deleteById(role.getId());

    }

    @Autowired
    ItemRepo itemRepo;
    private Item item = new Item("NAME", "ITEM desc", BigDecimal.valueOf(3.99));

    @Test
    public void SaveItemTest()
    {
        itemRepo.save(item);
        Assertions.assertNotNull(itemRepo.findById(item.getItemId()));
        itemRepo.deleteById(item.getItemId());

    }

//    @Autowired
//    DeliveryTypeRepo deliveryTypeRepo;
//    private DeliveryType deliveryType = new DeliveryType("delivery type");
//
//    @Test
//    public void deliveryTypeTest()
//    {
//        deliveryTypeRepo.save(deliveryType);
//        Assertions.assertNotNull(deliveryTypeRepo.findById(deliveryType.getId()));
//        deliveryTypeRepo.deleteById(deliveryType.getId());
//
//    }
//

//    @Autowired
//    OrdersRepo ordersRepo;
//
//    private Orders orders = new Orders("11-1-2022", Long.valueOf(1), Long.valueOf(1));
//
//    @Test
//    public void SaveOrdersTest()
//    {
//        ordersRepo.save(orders);
//        Assertions.assertNotNull(ordersRepo.findById(orders.getId()));
//        ordersRepo.deleteById(orders.getId());
//
//    }






}
