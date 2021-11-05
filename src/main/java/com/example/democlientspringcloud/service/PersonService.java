package com.example.democlientspringcloud.service;

import com.example.democlientspringcloud.exception.PersonNotFoundException;
import com.example.democlientspringcloud.model.Person;
import com.example.democlientspringcloud.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }
    public Person findById( Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
    public Person save(Person person){
        return personRepository.save(person);
    }
    public Person deleteById(Long id) throws PersonNotFoundException {
        Person personFromDb = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.deleteById(id);
        return personFromDb;
    }
}
