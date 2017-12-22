package com.techtest.vhforum.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/")
public interface BaseController<T> {

    ResponseEntity<T> get(Integer id);
    ResponseEntity<T> create(T entity);
    ResponseEntity<T> update(T entity, Integer id);
    ResponseEntity<List<T>> list();
    ResponseEntity<?> delete(Integer id);

}
