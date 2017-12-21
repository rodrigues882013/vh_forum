package com.techtest.vhforum.controllers;

import com.techtest.vhforum.dao.UserDAO;
import com.techtest.vhforum.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements BaseController<User>{

    @Autowired
    private UserDAO userDao;

    @Override
    @GetMapping(value = "${api.endpoints.users/{id}}")
    public ResponseEntity<User> get(@PathVariable("id") Integer id) {
        return null;
    }

    @Override
    @PostMapping(value = "${api.endpoints.users}")
    public ResponseEntity<User> create(@RequestBody User entity) {
        return null;
    }

    @Override
    @PutMapping(value = "${api.endpoints.users}/{id}")
    public ResponseEntity<User> update(@RequestBody User entity, @PathVariable("id") Integer id) {
        return null;
    }

    @Override
    @GetMapping(value = "${api.endpoints.users}")
    public ResponseEntity<List<User>> list() {
        return null;
    }

    @Override
    @DeleteMapping(value = "${api.endpoints.users}/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return null;
    }
}