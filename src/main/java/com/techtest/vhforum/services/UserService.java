package com.techtest.vhforum.services;

import com.techtest.vhforum.dao.UserDAO;
import com.techtest.vhforum.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private ActionsService<User, Integer> actionsService;

    public ResponseEntity<User> create(User u){
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
}
