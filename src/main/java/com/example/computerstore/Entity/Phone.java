package com.example.computerstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phone")
@PrimaryKeyJoinColumn(name = "phone_id")
public class Phone extends Product {
    private String color;
    private Integer capacity;
    @Column(name = "additional_accessories")
    private String additionalAccessories;
}
// id
// name
// price