package com.example.computerstore.Mapper;

import com.example.computerstore.Entity.Computer;
import com.example.computerstore.Entity.Electronics;

public class ComputerMapper {
    public static Computer map(Computer computer) {
        Computer newComputer = new Computer();
        newComputer.setId(computer.getId());
        newComputer.setName(computer.getName());
        newComputer.setPrice(computer.getPrice());
        newComputer.setType(computer.getType());
        newComputer.setProcessor(computer.getProcessor());
        newComputer.setRAM(computer.getRAM());
        newComputer.setAdditionalAccessories(computer.getAdditionalAccessories());
        return newComputer;
    }
    public static Computer map(Computer oldComputer, Computer newComputer) {
        oldComputer.setId(newComputer.getId());
        oldComputer.setName(newComputer.getName());
        oldComputer.setPrice(newComputer.getPrice());
        oldComputer.setType(newComputer.getType());
        oldComputer.setProcessor(newComputer.getProcessor());
        oldComputer.setRAM(newComputer.getRAM());
        oldComputer.setAdditionalAccessories(newComputer.getAdditionalAccessories());
        return oldComputer;
    }
}
