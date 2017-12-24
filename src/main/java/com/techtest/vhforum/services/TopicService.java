package com.techtest.vhforum.services;

import com.techtest.vhforum.dao.*;
import com.techtest.vhforum.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TopicService {

    @Autowired
    private CommentDAO commentDao;

    @Autowired
    private TopicDAO topicDao;

    @Autowired
    private CategoryDAO categoryDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private ActionsService<Topic, Integer> actionsService;

    public ResponseEntity<Topic> create(Topic t){
        User u = userDao.findOne(t.getUser().getId());
        t.setUser(u);

        Category c = categoryDao.findOne(t.getCategory().getId());
        t.setCategory(c);

        return actionsService.insert(t, topicDao);
    }

    public ResponseEntity<Topic> update(Integer id, Topic t){
        Topic newT = topicDao.findOne(id);
        newT.setText(t.getText());
        newT.setTitle(t.getTitle());
        return actionsService.update(topicDao, newT, id);
    }

    public ResponseEntity<List<Topic>> findAll(){
        return actionsService.findAll(topicDao);
    }

    public boolean delete(Integer id){
        return actionsService.delete(topicDao, id);
    }

    public ResponseEntity<Topic> findOne(Integer id){
        return actionsService.findOne(topicDao, id);
    }

    public ResponseEntity vote(Map<String, Integer> payload, Integer postId){

        if(payload.containsKey("vote")){
            Topic topic = topicDao.findOne(postId);
            Integer vote = payload.get("vote");
            if (vote > 0) topic.setUpVote();
            else topic.setDownVote();

            topicDao.save(topic);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<List<Topic>> findTopics(){
        List<Topic> topics = (List<Topic>) topicDao.findAll();

        return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
    }

    public ResponseEntity<List<Topic>> findTopicsByCategory(Integer id){
        Category c = categoryDao.findOne(id);
        List<Topic> topics = (List<Topic>) topicDao.findTopicByCategory(c);

        return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
    }

    public ResponseEntity<List<Topic>> findTopics(Integer id){
        User u = userDao.findOne(id);
        List<Topic> topics = topicDao.findTopicByUser(u);
        return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
    }


}
