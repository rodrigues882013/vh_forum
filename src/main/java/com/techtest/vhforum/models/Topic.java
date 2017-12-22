package com.techtest.vhforum.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "topics")
public class Topic extends BasePost {


    @OneToMany(cascade = ALL, mappedBy = "topic", targetEntity = Comment.class)
    private List<Comment> comments;

    @Column(name = "locked")
    private boolean locked;

    @Column
    private Double relevancy;

    public Topic(){
        super();
    }

    public Topic(String text, User user, List<Comment> repliesDate, Date created, Date lastUpdate) {
        super(text, user, lastUpdate, created);
        this.comments = comments;
        this.locked = false;
        this.relevancy = (super.upVote / (double) (Math.abs(super.downVote) + super.upVote)) * 100;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public List<Comment> getComments() {
        return comments;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public Integer getUpVote() {
        return upVote;
    }

    public void setUpVote(Integer upVote) {
        this.upVote = upVote;
    }

    public Double getRelevancy() {
        return relevancy;
    }

    public void setRelevancy(Double relevancy) {
        this.relevancy = relevancy;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Topic topic = (Topic) o;

        if (locked != topic.locked) return false;
        return comments != null ? comments.equals(topic.comments) : topic.comments == null;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (locked ? 1 : 0);
        return result;
    }
}
