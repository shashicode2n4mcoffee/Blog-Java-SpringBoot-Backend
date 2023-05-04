package com.app.blog.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class PostDto {
    private String postTitle;
    private String postMessage;
//    private String imageName;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "postTitle='" + postTitle + '\'' +
                ", postMessage='" + postMessage + '\'' +
                '}';
    }
}
