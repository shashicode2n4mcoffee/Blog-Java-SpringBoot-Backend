package com.app.blog.service.tagService;

import com.app.blog.entity.Tags;
import com.app.blog.exception.ResourceAlreadyExistsException;
import com.app.blog.exception.ResourceNotFoundException;
import com.app.blog.dto.TagDto;
import com.app.blog.repository.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<TagDto> getAllTags() {


        List<Tags> tags = tagRepository.findAll();

        List<TagDto> tagsList = tags.stream().map((tag)->{
            TagDto tagDto = new TagDto();
            BeanUtils.copyProperties(tag, tagDto);
            return tagDto;
        }).collect(Collectors.toList());
        return tagsList;

    }

    @Override
    public TagDto addTag(TagDto tagDto) {
        Optional<Tags> fetchedTag = tagRepository.findByTagTitle(tagDto.getTagTitle());
        if(fetchedTag.isPresent()){
            throw new ResourceAlreadyExistsException("Tag Already Exists");
        }

        Tags newTag = new Tags();
        BeanUtils.copyProperties(tagDto,newTag);

        Tags storedTag = tagRepository.save(newTag);

        TagDto responseTagDto = new TagDto();
        BeanUtils.copyProperties(storedTag,responseTagDto);
        return responseTagDto;
    }

    @Override
    public TagDto updateTag(Map<String, Object> updateTag, Long tagId) {

        Tags fetchedTag = tagRepository.findById(tagId).orElseThrow(()->new ResourceNotFoundException("Tag not found"));

        updateTag.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Tags.class, key);
            if (field != null && value != null){
                field.setAccessible(true);
                ReflectionUtils.setField(field,fetchedTag,value);
            }
        });

        Tags savedTag = tagRepository.save(fetchedTag);

        TagDto tagDto = new TagDto();
        BeanUtils.copyProperties(savedTag, tagDto);
        return tagDto;
    }

    @Override
    public TagDto getTagById(Long tagId) {
        Tags fetchTag = tagRepository.findById(tagId).orElseThrow(()->new ResourceNotFoundException("Tag not found"));

        TagDto tagDto = new TagDto();
        BeanUtils.copyProperties(fetchTag,tagDto);
        return tagDto;
    }

    @Override
    public void deleteTag(Long tagId) {
        Tags fetchTag = tagRepository.findById(tagId).orElseThrow(()-> new ResourceNotFoundException("Tag not found"));
        tagRepository.delete(fetchTag);
    }
}
