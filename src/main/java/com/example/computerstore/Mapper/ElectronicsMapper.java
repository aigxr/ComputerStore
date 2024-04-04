package com.example.computerstore.Mapper;

import com.example.computerstore.Entity.Electronics;
import com.example.computerstore.Entity.Phone;

public class ElectronicsMapper {
    public static Electronics map(Electronics electronics) {
        Electronics newElectronics = new Electronics();
        newElectronics.setId(electronics.getId());
        newElectronics.setName(electronics.getName());
        newElectronics.setPrice(electronics.getPrice());
        newElectronics.setType(electronics.getType());
        newElectronics.setAdditionalAccessories(electronics.getAdditionalAccessories());
        return newElectronics;
    }

    public static Electronics map(Electronics oldElectronic, Electronics newElectronic) {
        oldElectronic.setId(newElectronic.getId());
        oldElectronic.setName(newElectronic.getName());
        oldElectronic.setPrice(newElectronic.getPrice());
        oldElectronic.setType(newElectronic.getType());
        oldElectronic.setAdditionalAccessories(newElectronic.getAdditionalAccessories());
        return oldElectronic;
    }
}
