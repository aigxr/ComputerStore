package com.example.computerstore.Service;

import com.example.computerstore.Entity.Computer;
import com.example.computerstore.Entity.Product;
import com.example.computerstore.Exceptions.ComputerExistsException;
import com.example.computerstore.Exceptions.ProductNotFoundException;
import com.example.computerstore.Mapper.ComputerMapper;
import com.example.computerstore.Repository.ComputerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComputerService {
    private final ComputerRepository computerRepository;

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }
    public Computer getComputerById(Long computerId) {
        return computerRepository.findById(computerId)
                .orElseThrow(() -> new ProductNotFoundException("Computer with id: " + computerId + "was not found"));
    }
    @Transactional
    public Computer addComputer(Computer computer) {
        Computer mappedComputer = ComputerMapper.map(computer);
        return computerRepository.save(mappedComputer);
    }

    @Transactional
    public Computer updateComputer(Long computerId, Computer newComputer) {
        Computer foundComputer = getComputerById(computerId);
        if (newComputer.getName() == null || newComputer.getPrice() == null) {
            throw new ProductNotFoundException("Price and name values cannot be null");
        }

        Computer mappedComputer = ComputerMapper.map(foundComputer, newComputer);
        return computerRepository.save(mappedComputer);
    }
    @Transactional
    public void deleteComputer(Long computerId) {
        Computer foundComputer = getComputerById(computerId);
        computerRepository.deleteById(foundComputer.getId());
    }
}
