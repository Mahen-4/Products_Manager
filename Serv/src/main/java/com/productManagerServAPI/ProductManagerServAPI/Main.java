package com.productManagerServAPI.ProductManagerServAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/")
    public HelloJSON hello(){
         HelloJSON response = new HelloJSON(
                "hello JAVA !",
                List.of("JS","JS","JS"),
                new Person("i SAID JS",12)
                );
        return response;
    }
    record Person(String name, int age){}
    record HelloJSON(
            String hello,
            List<String> favProgrammingLang,
            Person person
    ){

    }
}
