package com.example.computerstore.Controller;

import com.example.computerstore.Entity.Computer;
import com.example.computerstore.Service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/computer")
public class ComputerController {
    private final ComputerService computerService;

    @GetMapping
    public List<Computer> getComputers() {
        return computerService.getAllComputers();
    }

    @GetMapping("/{id}")
    public Computer getComputer(@PathVariable Long id) {
        return computerService.getComputerById(id);
    }

    @PostMapping("/add")
    public Computer addComputer(@RequestBody Computer computer) {
        return computerService.addComputer(computer);
    }

    @PutMapping("/update/{id}")
    public Computer updateComputer(@PathVariable Long id, @RequestBody Computer computer) {
        return computerService.updateComputer(id, computer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComputer(@PathVariable Long id) {
        computerService.deleteComputer(id);
    }
}
