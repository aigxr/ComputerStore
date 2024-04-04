package com.example.computerstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "computer")
@PrimaryKeyJoinColumn(name = "computer_id")
public class Computer extends Product {
    private String processor;
    private Double RAM;
    @Column(name = "additional_accessories")
    private String additionalAccessories;
}
