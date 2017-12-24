package com.techtest.vhforum.dao;

import com.techtest.vhforum.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDAO extends CrudRepository<Category, Integer> {
}
