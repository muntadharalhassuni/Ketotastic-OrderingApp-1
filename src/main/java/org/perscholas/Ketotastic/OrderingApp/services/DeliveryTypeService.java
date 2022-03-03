package org.perscholas.Ketotastic.OrderingApp.services;

import org.perscholas.Ketotastic.OrderingApp.dao.DeliveryTypeRepo;
import org.perscholas.Ketotastic.OrderingApp.models.DeliveryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class DeliveryTypeService {

    @Autowired
    private DeliveryTypeRepo deliveryTypeRepo;

    public List<DeliveryType> listAll(){
        return deliveryTypeRepo.findAll();
    }

    public void saveDeliveryType(DeliveryType deliveryTypes){
        deliveryTypeRepo.save(deliveryTypes);
    }

    public DeliveryType getDeliveryTypeById(long id) {
        Optional<DeliveryType> optional = deliveryTypeRepo.findById(id);
        DeliveryType deliveryTypes = null;
        if (optional.isPresent()) {
            deliveryTypes = optional.get();
        } else {
            throw new RuntimeException(" delivery Item id not found for id :: " + id);
        }
        return deliveryTypes;
    }

    public void deleteDeliveryTypeById(long id) {
        this.deliveryTypeRepo.deleteById(id);
    }

    public Optional<DeliveryType> findById(Long id) {
        return deliveryTypeRepo.findById(id);
    }








}
