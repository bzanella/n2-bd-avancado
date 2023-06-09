package br.edu.unidep.interdisciplinar.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unidep.interdisciplinar.entity.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Procedure(name = "pr_delete_person")
    void deletarPessoa(@Param("id_pessoa_in") Long id);

}