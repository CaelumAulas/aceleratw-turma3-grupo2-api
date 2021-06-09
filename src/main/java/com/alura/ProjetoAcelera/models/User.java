package com.alura.ProjetoAcelera.models;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="users")
@Data
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;

    public User(){}

}
