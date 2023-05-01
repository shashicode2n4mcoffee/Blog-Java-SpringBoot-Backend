package com.app.blog.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyId;
    private String replyMessage;
    private Long likesCount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Comment comment;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

    public Long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Long likesCount) {
        this.likesCount = likesCount;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyMessage='" + replyMessage + '\'' +
                ", likesCount=" + likesCount +
                '}';
    }
}