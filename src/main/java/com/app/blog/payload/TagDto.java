package com.app.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TagDto {

    private Long tagId;
    @NotEmpty
    @Size(min=3, max=100)
    private String tagTitle;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    @Override
    public String toString() {
        return "TagDto{" +
                "tagId=" + tagId +
                ", tagTitle='" + tagTitle + '\'' +
                '}';
    }
}
