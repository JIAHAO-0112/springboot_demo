package com.example.demo.Controller;

import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonRepo personRepo;
    @GetMapping("/person-list")
    public Iterable<Person> personList(){
        return personRepo.findAll();
    }

    @PostMapping("/person-save")
    public Person createPerson(@RequestBody Person person){
        return personRepo.save(person);
    }

//    @PutMapping("/person-edit/{id}")
//    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson){
//        if(personRepo.existsById(id)){
//            updatedPerson.setId(id);
//            return personRepo.save(updatedPerson);
//        }
//        return null;
//    }

    @PutMapping("/person-edit/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson){
        Optional<Person> existingPerson = personRepo.findById(id);

        if (existingPerson.isPresent()){
            Person p = existingPerson.get();
            p.setName(updatedPerson.getName());
            p.setAge(updatedPerson.getAge());
            p.setSalary(updatedPerson.getSalary());
            personRepo.save(p);

            return p;
        }else {
            return new Person();
        }
    }

    @DeleteMapping("/person-delete/{id}")
    public String deletePerson(@PathVariable Long id){
        Optional<Person> opt = personRepo.findById(id);
        if (opt.isPresent()){
            Person p = opt.get();
            personRepo.delete(p);
            return "OK";
        }else {
            return "User does not exist";
        }
    }

    @GetMapping("/person/{id}")
    public Person find(@PathVariable Long id){
        Optional<Person> opt = personRepo.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            return new Person();
        }
    }
}
