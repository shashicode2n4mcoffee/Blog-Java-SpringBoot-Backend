package com.app.blog.service.tagService;

import com.app.blog.payload.TagDto;

import java.util.List;
import java.util.Map;

public interface TagService {
    List<TagDto> getAllTags();
    TagDto addTag(TagDto tagDto);
    TagDto updateTag(Map<String , Object>updateTag, Long userId);
    TagDto getTagById(Long tagId);
    void deleteTag(Long tagId);

}
