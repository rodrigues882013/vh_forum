package com.techtest.vhforum.dao;

import com.techtest.vhforum.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {
    User findUserByUsername(String username);
}
