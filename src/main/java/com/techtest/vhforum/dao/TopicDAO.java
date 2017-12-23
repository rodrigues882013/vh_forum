package com.techtest.vhforum.dao;

import com.techtest.vhforum.models.Topic;
import com.techtest.vhforum.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TopicDAO extends CrudRepository<Topic, Integer>{
    List<Topic> findTopicByUser(User u);
}
