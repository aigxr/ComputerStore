package com.example.computerstore.Repository;

import com.example.computerstore.Entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
