package com.theyellowpug.questionhandlerservice.controller;

import com.theyellowpug.questionhandlerservice.entity.Tag;
import com.theyellowpug.questionhandlerservice.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @PostMapping("")
    public String addTag(@RequestBody Tag tag){
        tagRepository.save(tag);
        return "Tag: "+tag.getValue()+" is successfully saved";
    }

    @GetMapping("")
    public List<Tag> getTags(){
        return tagRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteTagById(@PathVariable("id") Long id){
        tagRepository.deleteById(id);
        return "Tag at: "+id+"id was successfully deleted";
    }

}
