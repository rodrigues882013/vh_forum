package com.techtest.vhforum.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseController<T> {

    ResponseEntity<T> get(Integer id);
    ResponseEntity<T> create(T entity);
    ResponseEntity<T> update(T entity, Integer id);
    ResponseEntity<List<T>> list();
    ResponseEntity<?> delete(Integer id);

}
