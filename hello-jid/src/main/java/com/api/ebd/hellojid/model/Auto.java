package com.api.ebd.hellojid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;

@Table(name = "auto")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auto {
    @Id
    @GeneratedValue
    private int id;
    private String brand;
    private String type;
    private LocalDate birthDate;
}
