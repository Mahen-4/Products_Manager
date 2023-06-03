package com.productManagerServAPI.ProductManagerServAPI.controller;

import com.productManagerServAPI.ProductManagerServAPI.model.Content;
import com.productManagerServAPI.ProductManagerServAPI.model.Type;
import com.productManagerServAPI.ProductManagerServAPI.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin // CORS POLICY
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Content> findAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Content> findId(@PathVariable Integer id){
        return repository.findById(id);
    }
    @GetMapping("/filter")
    public List<Content> findByType(){
        return repository.findByType(Type.PHONES);
    }

   // @ResponseStatus(HttpStatus.CREATE) //want to send a message of success
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(!repository.existById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.delete(id);
    }
}
