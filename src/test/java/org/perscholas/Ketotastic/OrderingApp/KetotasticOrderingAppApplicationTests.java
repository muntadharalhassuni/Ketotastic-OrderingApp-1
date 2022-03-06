package org.perscholas.Ketotastic.OrderingApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.perscholas.Ketotastic.OrderingApp.dao.ItemRepo;
import org.perscholas.Ketotastic.OrderingApp.dao.RoleRepo;
import org.perscholas.Ketotastic.OrderingApp.models.Item;
import org.perscholas.Ketotastic.OrderingApp.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

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

//    @Autowired
//    ItemRepo itemRepo;
//    private Item item = new Item();
//
//    @Test
//    public void SaveItemTest()
//    {
//        itemRepo.save(item);
//        Assertions.assertNotNull(itemRepo.findById(item.getItemId()));
//        itemRepo.deleteById(item.getItemId());
//
//    }




}
