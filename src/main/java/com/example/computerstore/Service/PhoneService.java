package com.example.computerstore.Service;

import com.example.computerstore.Entity.Phone;
import com.example.computerstore.Exceptions.ProductNotFoundException;
import com.example.computerstore.Mapper.PhoneMapper;
import com.example.computerstore.Repository.PhoneRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Phone with such id was not found"));
    }

    @Transactional
    public Phone addPhone(Phone phone) {
        return phoneRepository.save(PhoneMapper.map(phone));
    }

    @Transactional
    public Phone updatePhoneById(Long phoneId, Phone newPhone) {
        Phone foundPhone = getPhoneById(phoneId);
        if (newPhone.getName() == null || newPhone.getPrice() == null) {
            throw new ProductNotFoundException("Phone cannot have price and name null");
        }

        Phone mappedPhone = PhoneMapper.map(foundPhone, newPhone);
        return phoneRepository.save(mappedPhone);
    }

    @Transactional
    public void deletePhoneById(Long phoneId) {
        Phone phone = getPhoneById(phoneId);
        phoneRepository.deleteById(phone.getId());
    }
}
