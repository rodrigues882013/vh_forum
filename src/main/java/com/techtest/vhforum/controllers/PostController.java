package com.techtest.vhforum.controllers;

import com.techtest.vhforum.dao.PostDAO;
import com.techtest.vhforum.models.BasePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController implements BaseController<BasePost> {

    @Autowired
    private PostDAO postDao;


    @Override
    @GetMapping(value = "${api.endpoints.posts/{id}}")
    public ResponseEntity<BasePost> get(@PathVariable("id") Integer id) {
        return null;
    }

    @Override
    @PostMapping(value = "${api.endpoints.posts")
    public ResponseEntity<BasePost> create(@RequestBody BasePost entity) {
        return null;
    }

    @Override
    @PutMapping(value = "${api.endpoints.posts/{id}}")
    public ResponseEntity<BasePost> update(@RequestBody BasePost entity, @PathVariable("id") Integer id) {
        return null;
    }

    @Override
    @GetMapping(value = "${api.endpoints.posts}")
    public ResponseEntity<List<BasePost>> list() {
        return null;
    }

    @Override
    @DeleteMapping(value = "${api.endpoints.posts/{id}}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return null;
    }


    @PostMapping(value = "${api.endpoints.posts/{id}/upvote}")
    public ResponseEntity<?> upVoting(){
        return null;
    }

    @PostMapping(value = "${api.endpoints.posts/{id}/downvote}")
    public ResponseEntity<?> downVoting(){
        return null;
    }
}
