package com.example.computerstore.Controller;

import com.example.computerstore.Entity.Computer;
import com.example.computerstore.Entity.Electronics;
import com.example.computerstore.Service.ElectronicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electronics")
@RequiredArgsConstructor
public class ElectronicsController {
    //miało nie być obsługi ale to przkopoiowane jest z innych serwisow
    //kazdy produkt ma podobny service
    private final ElectronicsService electronicsService;

    @GetMapping
    public List<Electronics> getAllElectronics() {
        return electronicsService.getAllElectronics();
    }

    @GetMapping("/{id}")
    public Electronics getElectronic(@PathVariable Long id) {
        return electronicsService.getElectronicById(id);
    }

    @PostMapping("/add")
    public Electronics addElectronic(@RequestBody Electronics electronics) {
        return electronicsService.addElectronics(electronics);
    }

    @PutMapping("/update/{id}")
    public Electronics updateElectronic(@PathVariable Long id, @RequestBody Electronics electronics) {
        return electronicsService.updateElectronics(id, electronics);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteElectronic(@PathVariable Long id) {
        electronicsService.deleteElectronic(id);
    }
}
