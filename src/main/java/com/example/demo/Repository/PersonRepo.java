package com.example.demo.Repository;

import com.example.demo.Entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {

}
