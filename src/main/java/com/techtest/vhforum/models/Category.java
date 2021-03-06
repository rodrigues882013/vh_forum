package com.techtest.vhforum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

	@Column(name = "name")
    private String name;

    @OneToMany(cascade = ALL, mappedBy = "category", targetEntity = Topic.class)
    @JsonIgnore
    private List<Topic> topics;

    public Category() {
    	super();
    }

    public Category(String name) {
    	this.name = name;
    }


    public String getName() {
        return name;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setName(String name) {
        this.name = name;
    }

    public List<Topic> getTopics(){
    	return topics;
    }

    public void setTopics(List<Topic> topic){
    	this.topics = topics;
    }
}