package com.example.democlientspringcloud.controller;

import com.example.democlientspringcloud.exception.PersonNotFoundException;
import com.example.democlientspringcloud.model.Person;
import com.example.democlientspringcloud.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/findAll")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/byId/{id}")
    public Person findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
    @PostMapping("/save")
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }
    @DeleteMapping("/delete/{id}")
    public Person deleteById(@PathVariable Long id)throws PersonNotFoundException {
        return personService.deleteById(id);
    }
}
