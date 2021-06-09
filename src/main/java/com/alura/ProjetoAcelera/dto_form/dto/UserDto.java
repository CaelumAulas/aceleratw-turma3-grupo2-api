package com.alura.ProjetoAcelera.dto_form.dto;

import com.alura.ProjetoAcelera.models.Brand;
import com.alura.ProjetoAcelera.models.User;
import org.springframework.data.domain.Page;

public class UserDto {
    private Long id;
    private String name;

    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Page<UserDto> convert(Page<User> users) {
        return users.map(UserDto::new);
    }
}
