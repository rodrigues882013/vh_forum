package com.techtest.vhforum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "topics")
public class Topic extends BaseEntity {


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

    @OneToMany(cascade = ALL, mappedBy = "topic", targetEntity = Comment.class)
    @JsonIgnore
    private List<Comment> comments;

    @Column(name = "locked")
    private boolean locked;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name="category_id")
    private Category category;

    @Column
    private Double relevancy;

    public Topic(){
        super();
    }

    public Topic(String text, User user, String title) {
        super();
        this.title = title;
        this.text = text;
        this.user = user;
        this.locked = false;
        upVote = 0;
        downVote = 0;
        this.relevancy = (upVote / (double) (Math.abs(downVote) + upVote)) * 100;
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

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setLocked(boolean locked) {
        this.locked = locked;
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

    public Double getRelevancy() {
        return relevancy;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setRelevancy(Double relevancy) {
        this.relevancy = relevancy;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public Category getCategory() {
        return category;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void setCategory(Category category) {
        this.category = category;
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

        Topic topic = (Topic) o;

        if (locked != topic.locked) return false;
        if (title != null ? !title.equals(topic.title) : topic.title != null) return false;
        if (text != null ? !text.equals(topic.text) : topic.text != null) return false;
        if (user != null ? !user.equals(topic.user) : topic.user != null) return false;
        if (upVote != null ? !upVote.equals(topic.upVote) : topic.upVote != null) return false;
        if (downVote != null ? !downVote.equals(topic.downVote) : topic.downVote != null) return false;
        if (comments != null ? !comments.equals(topic.comments) : topic.comments != null) return false;
        if (category != null ? !category.equals(topic.category) : topic.category != null) return false;
        return relevancy != null ? relevancy.equals(topic.relevancy) : topic.relevancy == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (upVote != null ? upVote.hashCode() : 0);
        result = 31 * result + (downVote != null ? downVote.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (locked ? 1 : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (relevancy != null ? relevancy.hashCode() : 0);
        return result;
    }
}
