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
@Table(name = "electronics")
@PrimaryKeyJoinColumn(name = "electronics_id")
public class Electronics extends Product {
    @Column(name = "additional_accessories")
    private String additionalAccessories;
}
