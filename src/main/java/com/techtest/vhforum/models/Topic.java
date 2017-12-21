package com.techtest.vhforum.models;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "topics")
public class Topic extends BasePost {


    @OneToMany(cascade = ALL, mappedBy = "replies", targetEntity = Reply.class)
    private List<Reply> replies;

    @Column(name = "locked")
    private boolean locked;

    @Column
    private Double relevancy;

    public Topic(String text, User user, List<Reply> replies) {
        super(text, user);
        this.replies = replies;
        this.locked = false;
        this.relevancy = (super.upVote / (double) (Math.abs(super.downVote) + super.upVote)) * 100;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public List<Reply> getReplies() {
        return replies;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
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
        return replies != null ? replies.equals(topic.replies) : topic.replies == null;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (replies != null ? replies.hashCode() : 0);
        result = 31 * result + (locked ? 1 : 0);
        return result;
    }
}
