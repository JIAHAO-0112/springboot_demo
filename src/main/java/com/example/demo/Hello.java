package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/demo")
    public ArrayList<String> demo(){
        ArrayList<String> person = new ArrayList<>();
        person.add("Aaaa Aaa Aaa");
        person.add("Bbbb Bbb Bbb");
        person.add("Cccc Ccc Ccc");
        return person;
    }

    @GetMapping("/demo2")
    public ArrayList<Person> demo2(){
        ArrayList<Person> persons = new ArrayList<>();

        Person p1 = new Person();
        p1.name = "Aaaa Aaa Aaa";
        p1.address = "address 1 address 1";

        Person p2 = new Person();
        p2.name = "Bbbb Bbb Bbb";
        p2.address = "address 2 address 2";

        persons.add(p1);
        persons.add(p2);

        return persons;
    }
}
