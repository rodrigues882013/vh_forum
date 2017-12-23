package com.techtest.vhforum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.techtest.vhforum.serializers.UserSerializer;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BasePost extends BaseEntity{

    @Column(name = "title")
    protected String title;

    @Column(name = "text")
    protected String text;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    protected User user;

    @Column(name = "upvote")
    protected Integer upVote;

    @Column(name = "downvote")
    protected Integer downVote;

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public BasePost() {
        super();
        this.downVote = 0;
        this.upVote = 0;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public BasePost(String text, User user, String title) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.downVote = 0;
        this.upVote = 0;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public Integer getId() {
        return id;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setId(Integer id) {
        this.id = id;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


     public String getTitle() {
        return title;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setTitle(String title) {
        this.title = title;
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
        this.downVote -= 1;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasePost basePost = (BasePost) o;

        if (!id.equals(basePost.id)) return false;
        if (!text.equals(basePost.text)) return false;
        return user.equals(basePost.user);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
