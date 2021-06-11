package com.alura.ProjetoAcelera.controller;

import com.alura.ProjetoAcelera.dto_form.dto.UserDto;
import com.alura.ProjetoAcelera.dto_form.form.UserForm;
import com.alura.ProjetoAcelera.models.User;
import com.alura.ProjetoAcelera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired private UserRepository userRepository;

    @GetMapping
    @Cacheable(value = "usersList")
    public Page<UserDto> getAllUsers(@RequestParam(required = false) String name,
                                       @PageableDefault(sort = "name",
                                               direction = Sort.Direction.ASC,
                                               page = 0, size = 10)
                                               Pageable pages) {

        if (name == null) {
            Page<User> users = userRepository.findAll(pages);
            return UserDto.convert(users);
        } else {
            Page<User> users = userRepository.findByName(name, pages);
            return UserDto.convert(users);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(new UserDto(user.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "usersList", allEntries = true)
    public ResponseEntity<UserDto> registerUser(@RequestBody UserForm form,
                                                  UriComponentsBuilder uriBuilder) {
        User user = form.convert(userRepository);
        userRepository.save(user);

        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "usersList", allEntries = true)
    public ResponseEntity<UserDto> updateBrand(@PathVariable Long id,
                                                @RequestBody  UserForm form) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = form.update(id, userRepository);
            return ResponseEntity.ok(new UserDto(user));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "usersList", allEntries = true)
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }




}
