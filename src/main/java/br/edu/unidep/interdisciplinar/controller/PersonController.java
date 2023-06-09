package br.edu.unidep.interdisciplinar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pessoas")
public class PersonController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/deletar/{id}")
    public void deletarPessoa(@PathVariable Long id, @RequestParam(name = "confirmar", defaultValue = "true") boolean confirmar) {
        if (confirmar) {
            String sql = "CALL pr_delete_person(?)";
            jdbcTemplate.update(sql, id);
            System.out.println("Registro deletado com sucesso!");
            
        } else {
            System.out.println("Erro ao deletar registro!");

        }
    }

    @GetMapping("/listar/{id}")
    public Map<String, Object> getPessoaById(@PathVariable Long id) {
        String sql = "SELECT fn_list_person_by_id(?)";
        return jdbcTemplate.queryForMap(sql, id);
    }
}