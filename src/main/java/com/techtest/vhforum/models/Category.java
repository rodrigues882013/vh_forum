package com.techtest.vhforum.models;

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
    private List<Topic> topics;


    public Category() {
    	super();
    }

    public Category(String name, Category category) {
    	this.name = name;
    	this.category = category;
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