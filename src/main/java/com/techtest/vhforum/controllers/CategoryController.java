package com.techtest.vhforum.controllers;

import com.techtest.vhforum.models.Category;
import com.techtest.vhforum.models.Topic;
import com.techtest.vhforum.services.CategoryService;
import com.techtest.vhforum.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController implements BaseController<Category> {

    @Autowired
    private CategoryService service;

    @Autowired
    private TopicService topicService;

    @Override
    @GetMapping(value = "${api.endpoints.categories}/{id}")
    public ResponseEntity<Category> get(Integer id) {
        return service.findOne(id);
    }

    @Override
    @PostMapping(value = "${api.endpoints.categories}")
    public ResponseEntity<Category> create(Category entity) {
        return service.create(entity);
    }

    @Override
    @PutMapping(value = "${api.endpoints.categories}/{id}")
    public ResponseEntity<Category> update(Category entity, Integer id) {
        return null;
    }

    @Override
    @GetMapping(value = "${api.endpoints.categories}")
    public ResponseEntity<List<Category>> list() {
        return service.findAll();
    }

    @Override
    @DeleteMapping(value = "${api.endpoints.categories}/{id}")
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }

    @GetMapping(value = "${api.endpoints.categories}/{id}/topics")
    public ResponseEntity<List<Topic>> getTopicsByCategoryId(@PathVariable("id") Integer id) {
        return topicService.findTopicsByCategory(id);
    }
}
