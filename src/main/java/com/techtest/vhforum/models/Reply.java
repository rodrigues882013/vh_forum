package com.techtest.vhforum.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "replies")
public class Reply extends BasePost {

    @ManyToOne(targetEntity = Topic.class)
    @JoinColumn(name="topic_id")
    private Topic topic;

    public Reply(String text, User user, Topic topic, Date created, Date lastUpdate) {
        super(text, user, lastUpdate, created);
        this.topic = topic;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Reply reply = (Reply) o;

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
