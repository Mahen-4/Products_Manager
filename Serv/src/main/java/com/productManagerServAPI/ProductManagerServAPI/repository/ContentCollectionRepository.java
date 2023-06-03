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
    private final List<Content> contentList = new ArrayList<>(); // new array of Content type

    public ContentCollectionRepository(){} // constructor

    public List<Content> findAll(){ // find all content
        return contentList;
    }

    public Optional<Content> findById(Integer id){
    //We use Optional to check the presence of an optional element (an element that may not exist) before using it
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
        //stream is used to make operations on elements
    }
    public List<Content> findByType(Type type){

        Predicate<Content> byType = c -> c.type().equals(type);


        return contentList.stream().filter(byType).collect(Collectors.toList());
    }
    public void save(Content content){
        // if we find one we delete it and we add it back (not the best way to do that update actually but will change later )
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
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

        contentList.add(a);
        contentList.add(b);
        contentList.add(c);
    }


    public boolean existById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
