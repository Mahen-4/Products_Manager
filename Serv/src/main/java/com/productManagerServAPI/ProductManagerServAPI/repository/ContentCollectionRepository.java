package com.productManagerServAPI.ProductManagerServAPI.repository;

import com.productManagerServAPI.ProductManagerServAPI.model.Content;
import com.productManagerServAPI.ProductManagerServAPI.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>(); // new array of Content type

    public ContentCollectionRepository(){} // constructor

    public List<Content> findAll(){ // find all content
        return content;
    }

    public Optional<Content> findById(Integer id){
    //We use Optional to check the presence of an optional element (an element that may not exist) before using it
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
        //stream is used to make operations on elements
    }
    public List<Content> findByType(Type type){

        Predicate<Content> byType = c -> c.type().equals(type);


        return content.stream().filter(byType).collect(Collectors.toList());
    }
    @PostConstruct
    private void init(){
        Content a = new Content(
                1,
                "Samsung s23",
                "Brand : Samsung",
                800,
                150,
                Type.PHONES,
                "url/image",
                true
        );
        Content b = new Content(
                2,
                "Iphone 14",
                "Brand : Iphone",
                900,
                50,
                Type.PHONES,
                "url/image",
                true
        );
        Content c = new Content(
                3,
                "League of Legends Skin",
                "A skin of Caitlyn",
                10,
                20,
                Type.VIDEO_GAMES,
                "url/image",
                true
        );

        content.add(a);
        content.add(b);
        content.add(c);
    }
}
