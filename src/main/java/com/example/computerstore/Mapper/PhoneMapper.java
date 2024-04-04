package com.example.computerstore.Mapper;

import com.example.computerstore.Entity.Phone;

public class PhoneMapper {
    public static Phone map(Phone phone) {
        Phone newPhone = new Phone();
        newPhone.setId(phone.getId());
        newPhone.setName(phone.getName());
        newPhone.setPrice(phone.getPrice());
        newPhone.setColor(phone.getColor());
        newPhone.setType(phone.getType());
        newPhone.setCapacity(phone.getCapacity());
        newPhone.setAdditionalAccessories(phone.getAdditionalAccessories());
        return newPhone;
    }
    public static Phone map(Phone oldPhone, Phone newPhone) {
        oldPhone.setName(newPhone.getName());
        oldPhone.setPrice(newPhone.getPrice());
        oldPhone.setColor(newPhone.getColor());
        oldPhone.setCapacity(newPhone.getCapacity());
        oldPhone.setAdditionalAccessories(newPhone.getAdditionalAccessories());
        return oldPhone;
    }
}
