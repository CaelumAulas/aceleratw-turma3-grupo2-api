package com.alura.ProjetoAcelera.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Brand(){}

    public Brand(String name) {
        this.name = name;
    }
}
