package com.productManagerServAPI.ProductManagerServAPI.controller;

import com.productManagerServAPI.ProductManagerServAPI.model.Content;
import com.productManagerServAPI.ProductManagerServAPI.model.Type;
import com.productManagerServAPI.ProductManagerServAPI.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Content> findAll(){
        return repository.findAll();
    }
    @GetMapping("/id")
    public Optional<Content> findId(){
        return repository.findById(2);
    }
    @GetMapping("/filter")
    public List<Content> findByType(){
        return repository.findByType(Type.PHONES);
    }
}
