package com.techtest.vhforum.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ActionsService <T, E extends Serializable> {

    public T insert(T entity, CrudRepository<T, E> dao){
        return dao.save(entity);
    }

    public T findOne(CrudRepository<T, E> dao, E id){
        return dao.findOne(id);
    }

    public List<T> findAll(CrudRepository<T, E> dao){
        return (List<T>) dao.findAll();
    }

    public boolean delete(CrudRepository<T, E> dao, E id){
        try {
            dao.delete(id);
            return true;

        } catch (Exception err){
            return false;
        }
    }
}
