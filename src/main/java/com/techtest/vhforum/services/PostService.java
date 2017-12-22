package com.techtest.vhforum.services;

import com.techtest.vhforum.dao.PostDAO;
import com.techtest.vhforum.models.BasePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    private PostDAO postDao;

    @Autowired
    private ActionsService<BasePost, Integer> actionsService;

    public ResponseEntity<BasePost> create(BasePost u){
        return actionsService.insert(u, postDao);
    }

    public ResponseEntity<List<BasePost>> findAll(){
        return actionsService.findAll(postDao);
    }

    public boolean delete(Integer id){
        return actionsService.delete(postDao, id);
    }

    public ResponseEntity<BasePost> findOne(Integer id){
        return actionsService.findOne(postDao, id);
    }

    public ResponseEntity vote(Map<String, Integer> payload, Integer postId){

        if(payload.containsKey("vote")){
            BasePost post = postDao.findOne(postId);
            Integer vote = payload.get("vote");
            if (vote > 0) post.setUpVote();
            else post.setDownVote();
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
