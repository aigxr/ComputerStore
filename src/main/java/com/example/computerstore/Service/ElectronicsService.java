package com.example.computerstore.Service;

import com.example.computerstore.Entity.Computer;
import com.example.computerstore.Entity.Electronics;
import com.example.computerstore.Exceptions.ProductNotFoundException;
import com.example.computerstore.Mapper.ElectronicsMapper;
import com.example.computerstore.Repository.ElectronicsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectronicsService {
    //miało nie być obsługi ale to przkopoiowane jest z innych serwisow
    //kazdy produkt ma podobny service
    private final ElectronicsRepository electronicsRepository;

    public List<Electronics> getAllElectronics() {
        return electronicsRepository.findAll();
    }

    public Electronics getElectronicById(Long id) {
        return electronicsRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Electronic with such id was not found"));
    }

    @Transactional
    public Electronics addElectronics(Electronics electronics) {
        Electronics mappedElectronics = ElectronicsMapper.map(electronics);
        return electronicsRepository.save(mappedElectronics);
    }

    @Transactional
    public Electronics updateElectronics(Long electronicId, Electronics newElectronic) {
        Electronics foundElectronic = getElectronicById(electronicId);
        if (newElectronic.getName() == null || newElectronic.getPrice() == null) {
            throw new ProductNotFoundException("Price and name values cannot be null");
        }

        Electronics mappedElectronic = ElectronicsMapper.map(foundElectronic, newElectronic);
        return electronicsRepository.save(mappedElectronic);
    }

    @Transactional
    public void deleteElectronic(Long electronicId) {
        Electronics electronic = getElectronicById(electronicId);
        electronicsRepository.deleteById(electronic.getId());
    }
}
