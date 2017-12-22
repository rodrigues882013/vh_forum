package com.techtest.vhforum.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BasePost extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    protected Integer id;

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
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public BasePost(String text, User user, Date created, Date lastUpdate) {
        this.text = text;
        this.user = user;
        this.downVote = 0;
        this.upVote = 0;
        super.created = created;
        super.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUpVote() {
        return upVote;
    }

    public void setUpVote() {
        this.upVote += 1;
    }

    public Integer getDownVote() {
        return downVote;
    }

    public void setDownVote() {
        this.downVote -= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasePost basePost = (BasePost) o;

        if (!id.equals(basePost.id)) return false;
        if (!text.equals(basePost.text)) return false;
        return user.equals(basePost.user);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
