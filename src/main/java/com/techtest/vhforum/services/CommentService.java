package com.techtest.vhforum.services;

import com.techtest.vhforum.dao.CommentDAO;
import com.techtest.vhforum.dao.TopicDAO;
import com.techtest.vhforum.dao.UserDAO;
import com.techtest.vhforum.models.Comment;
import com.techtest.vhforum.models.Topic;
import com.techtest.vhforum.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentDAO commentDao;

    @Autowired
    private TopicDAO topicDao;

    @Autowired
    private UserDAO userDao;

    public ResponseEntity<Comment> createComment(Integer id, Comment c){
        Topic t = topicDao.findOne(id);
        c.setTopic(t);
        Comment persisted = commentDao.save(c);

        return new ResponseEntity<Comment>(persisted, HttpStatus.CREATED);
    }

    public ResponseEntity<Comment> updateComment(Integer topicId, Integer id, Comment c){
        Topic t = topicDao.findOne(topicId);
        Comment old = commentDao.findOne(id);
        old.setTopic(t);
        old.setText(c.getText());
        Comment persisted = commentDao.save(old);

        return new ResponseEntity<Comment>(persisted, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Comment>> findComments(Integer topicId){
        Topic t = (Topic) topicDao.findOne(topicId);
        List<Comment> comments = commentDao.findCommentsByTopic(t);

        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }

    public ResponseEntity vote(Map<String, Integer> payload, Integer postId){

        if(payload.containsKey("vote")){
            Comment topic = commentDao.findOne(postId);
            Integer vote = payload.get("vote");
            if (vote > 0) topic.setUpVote();
            else topic.setDownVote();

            commentDao.save(topic);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<List<Comment>> findCommentsByUserId(Integer id){
        User u = userDao.findOne(id);
        List<Comment> comments = commentDao.findCommentsByUser(u);
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }
}
