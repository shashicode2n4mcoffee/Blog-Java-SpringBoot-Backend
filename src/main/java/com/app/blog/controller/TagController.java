package com.app.blog.controller;

import com.app.blog.dto.TagDto;
import com.app.blog.service.tagService.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags(){
        List<TagDto> tagDtoList = tagService.getAllTags();
        return ResponseEntity.ok(tagDtoList);
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<TagDto> getTagById(@PathVariable("tagId") Long tagId){
        TagDto tagDto = tagService.getTagById(tagId);
        return ResponseEntity.ok(tagDto);
    }

    @PostMapping
    public ResponseEntity<TagDto> addTagDto(@Valid @RequestBody TagDto tagDto){
        TagDto savedTagDto = tagService.addTag(tagDto);
        return ResponseEntity.ok(savedTagDto);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<String> deleteTag(@PathVariable("tagId") Long tagId){
        tagService.deleteTag(tagId);
        return ResponseEntity.ok("User Delete Successfully");
    }


    @PatchMapping("/{tagId}")
    public ResponseEntity<TagDto> updateTag(@PathVariable("tagId") Long tagId, @RequestBody Map<String,Object> updates){
        TagDto updatedTagDto = tagService.updateTag(updates, tagId);
        return ResponseEntity.ok(updatedTagDto);
    }


}
