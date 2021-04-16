package com.backend.valid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.valid.data.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
