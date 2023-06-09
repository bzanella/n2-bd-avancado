package br.edu.unidep.interdisciplinar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pessoas")
public class PersonController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id, @RequestParam(name = "confirmar", defaultValue = "true") boolean confirmar) {
        if (confirmar) {
            String sql = "CALL pr_delete_person(?)";
            jdbcTemplate.update(sql, id);
            return ResponseEntity.ok("Registro deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar registro!");
        }
    }

    @GetMapping("/listar/{id}")
    public Map<String, Object> getPessoaById(@PathVariable Long id) {
        String sql = "SELECT fn_list_person_by_id(?)";
        return jdbcTemplate.queryForMap(sql, id);
    }
}