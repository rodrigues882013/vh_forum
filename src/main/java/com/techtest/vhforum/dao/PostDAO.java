package com.techtest.vhforum.dao;

import com.techtest.vhforum.models.BasePost;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PostDAO extends CrudRepository<BasePost, Integer>{
}
