package com.techtest.vhforum.services;

import com.techtest.vhforum.dao.CategoryDAO;
import com.techtest.vhforum.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDao;

    @Autowired
    private ActionsService<Category, Integer> actionsService;

    public ResponseEntity<Category> create(Category c){
        return actionsService.insert(c, categoryDao);
    }

    public ResponseEntity<List<Category>> findAll(){
        return actionsService.findAll(categoryDao);
    }

    public boolean delete(Integer id){
        return actionsService.delete(categoryDao, id);
    }

    public ResponseEntity<Category> findOne(Integer id){
        return actionsService.findOne(categoryDao, id);
    }

}
