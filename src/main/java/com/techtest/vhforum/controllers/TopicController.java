package com.techtest.vhforum.controllers;

import com.techtest.vhforum.models.Comment;
import com.techtest.vhforum.models.Topic;
import com.techtest.vhforum.services.CommentService;
import com.techtest.vhforum.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TopicController implements BaseController<Topic> {

    @Autowired
    private TopicService service;

    @Autowired
    private CommentService commentService;


    @Override
    @GetMapping(value = "${api.endpoints.topics}/{id}")
    public ResponseEntity<Topic> get(@PathVariable("id") Integer id) {
        return service.findOne(id);
    }

    @Override
    @PostMapping(value = "${api.endpoints.topics}")
    public ResponseEntity<Topic> create(@RequestBody Topic entity) {
        return service.create(entity);
    }

    @Override
    @PutMapping(value = "${api.endpoints.topics}/{id}")
    public ResponseEntity<Topic> update(@RequestBody Topic entity, @PathVariable("id") Integer id) {
        return service.update(id, entity);
    }


    @GetMapping(value = "${api.endpoints.topics}")
    public ResponseEntity<List<Topic>> list() {
        return service.findTopics();
    }

    @Override
    @DeleteMapping(value = "${api.endpoints.topics}/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return null;
    }


    @PostMapping(value = "${api.endpoints.topics}/{id}/vote")
    public ResponseEntity<?> vote(@PathVariable("id") Integer id, @RequestBody Map<String, Integer> payload){
        return service.vote(payload, id);
    }

    @GetMapping(value = "${api.endpoints.topics}/{id}/comments")
    public ResponseEntity<List<Comment>> getCommentsByTopic(@PathVariable("id") Integer id) {
        return commentService.findComments(id);
    }

    @PostMapping(value = "${api.endpoints.topics}/{id}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
        return commentService.createComment(id, comment);
    }

    @PutMapping(value = "${api.endpoints.topics}/{topicId}/comments/{id}")
    public ResponseEntity<Comment> updateComment(
            @PathVariable("topicId") Integer topicId,
            @PathVariable("id") Integer id,
            @RequestBody Comment comment) {

        return commentService.updateComment(topicId, id, comment);
    }

}
