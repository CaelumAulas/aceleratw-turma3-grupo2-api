package com.alura.ProjetoAcelera.models;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    private String name;
    private String password;

    public User(){}

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

}
