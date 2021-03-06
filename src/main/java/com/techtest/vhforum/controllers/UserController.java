package com.techtest.vhforum.controllers;

import com.techtest.vhforum.models.Comment;
import com.techtest.vhforum.models.Topic;
import com.techtest.vhforum.models.User;
import com.techtest.vhforum.services.CommentService;
import com.techtest.vhforum.services.TopicService;
import com.techtest.vhforum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements BaseController<User>{

    @Autowired
    private UserService service;

    @Autowired
    private TopicService topicService;

    @Autowired
    private CommentService commentService;

    @Override
    @GetMapping(value = "${api.endpoints.users}/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Integer id) {
        return service.findOne(id);
    }

    @Override
    @PostMapping(value = "${api.endpoints.register}")
    public ResponseEntity<User> create(@RequestBody User entity) {
        return service.create(entity);
    }

    @Override
    @PutMapping(value = "${api.endpoints.users}/{id}")
    public ResponseEntity<User> update(@RequestBody User entity, @PathVariable("id") Integer id) {
        return null;
    }

    @Override
    @GetMapping(value = "${api.endpoints.users}")
    public ResponseEntity<List<User>> list() {
        return service.findAll();
    }

    @Override
    @DeleteMapping(value = "${api.endpoints.users}/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return null;
    }

    @GetMapping(value = "${api.endpoints.users}/{id}/topics")
    public ResponseEntity<List<Topic>> getTopicsByUserId(@PathVariable("id") Integer id) {
        return topicService.findTopics(id);
    }

    @GetMapping(value = "${api.endpoints.users}/{id}/comment")
    public ResponseEntity<List<Comment>> getCommentByUserId(@PathVariable("id") Integer id) {
        return commentService.findCommentsByUserId(id);
    }

}
