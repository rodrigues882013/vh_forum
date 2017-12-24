package com.techtest.vhforum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column(name = "text")
    protected String text;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    protected User user;

    @Column(name = "upvote")
    protected Integer upVote;

    @Column(name = "downvote")
    protected Integer downVote;

    @ManyToOne(targetEntity = Topic.class)
    @JoinColumn(name="topic_id")
    @JsonIgnore
    private Topic topic;

    public Comment(){
        super();
    }

    public Comment(String text, User user, Topic topic) {
        super();
        this.text = text;
        this.user = user;
        this.topic = topic;
        upVote = 0;
        downVote = 0;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public Topic getTopic() {
        return topic;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public String getText() {
        return text;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setText(String text) {
        this.text = text;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public User getUser() {
        return user;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setUser(User user) {
        this.user = user;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public Integer getUpVote() {
        return upVote;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setUpVote() {
        this.upVote += 1;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public Integer getDownVote() {
        return downVote;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setDownVote() {
        this.downVote += 1;
    }


    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Comment reply = (Comment) o;

        return topic != null ? topic.equals(reply.topic) : reply.topic == null;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        return result;
    }
}
