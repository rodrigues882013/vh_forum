package com.techtest.vhforum.dao;

import com.techtest.vhforum.models.Comment;
import com.techtest.vhforum.models.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentDAO extends CrudRepository<Comment, Integer> {
    List<Comment> findCommentsByTopic(Topic t);
}
