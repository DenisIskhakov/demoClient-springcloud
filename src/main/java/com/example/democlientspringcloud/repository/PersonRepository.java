package com.example.democlientspringcloud.repository;

import com.example.democlientspringcloud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
