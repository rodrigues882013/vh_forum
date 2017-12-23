package com.techtest.vhforum.services;

import com.techtest.vhforum.dao.TopicDAO;
import com.techtest.vhforum.dao.UserDAO;
import com.techtest.vhforum.models.Topic;
import com.techtest.vhforum.models.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private TopicDAO topicDao;

    @Autowired
    private ActionsService<User, Integer> actionsService;

    public String generateHash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkHash(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }

    public ResponseEntity<User> create(User u){
        u.setPassword(generateHash(u.getPassword()));
        return actionsService.insert(u, userDao);
    }

    public ResponseEntity<List<User>> findAll(){
        return actionsService.findAll(userDao);
    }

    public boolean delete(Integer id){
        return actionsService.delete(userDao, id);
    }

    public ResponseEntity<User> findOne(Integer id){
        return actionsService.findOne(userDao, id);
    }

    public ResponseEntity<List<Topic>> findTopics(Integer id){
        User u = userDao.findOne(id);
        List<Topic> topics = topicDao.findTopicByUser(u);
        return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
    }
}
