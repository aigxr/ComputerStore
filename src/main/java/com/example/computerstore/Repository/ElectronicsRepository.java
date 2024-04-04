package com.example.computerstore.Repository;

import com.example.computerstore.Entity.Electronics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Long> {
}
