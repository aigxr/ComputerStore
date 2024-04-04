package com.example.computerstore.Controller;

import com.example.computerstore.Entity.Phone;
import com.example.computerstore.Service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneController {
    private final PhoneService phoneService;

    @GetMapping
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @GetMapping("/{id}")
    public Phone getPhoneById(@PathVariable Long id) {
        return phoneService.getPhoneById(id);
    }

    @PostMapping("/add")
    public Phone addPhone(@RequestBody Phone phone) {
        return phoneService.addPhone(phone);
    }

    @PutMapping("/update/{id}")
    public Phone updatePhone(@PathVariable Long id, @RequestBody Phone newPhone) {
        return phoneService.updatePhoneById(id, newPhone);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhoneById(@PathVariable Long id) {
        phoneService.deletePhoneById(id);
    }
}
