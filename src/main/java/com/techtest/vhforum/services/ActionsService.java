package com.techtest.vhforum.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ActionsService <T, E extends Serializable> {

    public ResponseEntity<T> insert(T entity, CrudRepository<T, E> dao){
        return new ResponseEntity<T>(dao.save(entity), HttpStatus.CREATED);
    }

    public ResponseEntity<T> findOne(CrudRepository<T, E> dao, E id){
        return new ResponseEntity<T>(dao.findOne(id), HttpStatus.OK);
    }

    public ResponseEntity<List<T>> findAll(CrudRepository<T, E> dao){
        return new ResponseEntity<List<T>> ((List<T>) dao.findAll(), HttpStatus.OK);
    }

    public boolean delete(CrudRepository<T, E> dao, E id){
        try {
            dao.delete(id);
            return true;

        } catch (Exception err){
            return false;
        }
    }

    public ResponseEntity<T> update(CrudRepository<T, E> dao, T entity, E id){
        if (delete(dao, id)){
            return new ResponseEntity<T>(dao.save(entity), HttpStatus.OK);
        }

        return null;
    }
}
