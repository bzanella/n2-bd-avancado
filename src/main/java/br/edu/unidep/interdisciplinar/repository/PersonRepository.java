package br.edu.unidep.interdisciplinar.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.interdisciplinar.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

}