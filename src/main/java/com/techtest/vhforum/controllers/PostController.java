package com.techtest.vhforum.controllers;

import com.techtest.vhforum.models.BasePost;
import com.techtest.vhforum.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PostController implements BaseController<BasePost> {

    @Autowired
    private PostService service;


    @Override
    @GetMapping(value = "${api.endpoints.posts/{id}}")
    public ResponseEntity<BasePost> get(@PathVariable("id") Integer id) {
        return service.findOne(id);
    }

    @Override
    @PostMapping(value = "${api.endpoints.posts")
    public ResponseEntity<BasePost> create(@RequestBody BasePost entity) {
        return service.create(entity);
    }

    @Override
    @PutMapping(value = "${api.endpoints.posts/{id}}")
    public ResponseEntity<BasePost> update(@RequestBody BasePost entity, @PathVariable("id") Integer id) {
        return null;
    }

    @Override
    @GetMapping(value = "${api.endpoints.posts}")
    public ResponseEntity<List<BasePost>> list() {
        return service.findAll();
    }

    @Override
    @DeleteMapping(value = "${api.endpoints.posts/{id}}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return null;
    }


    @PostMapping(value = "${api.endpoints.posts/{id}/vote}")
    public ResponseEntity<?> vote(@PathVariable("id") Integer id, @RequestBody Map<String, Integer> payload){
        return service.vote(payload, id);
    }

}
