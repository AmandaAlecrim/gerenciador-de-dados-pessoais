package com.api.gerenciadordepessoas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gerenciadordepessoas.entities.Pessoa;
import com.api.gerenciadordepessoas.repositories.PessoaRepository;

@RestController // Para o springboot reconhecer a classe como um resource
@RequestMapping(value = "/pessoas") // Definindo o caminho de saída como "localhost:8080/pessoas"
public class PessoaResource {

    @Autowired // injeta dependência
    private PessoaRepository pessoaRepository;

    @GetMapping // mostra todas as pessoas em forma de lista por meio de requisição GET
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> list = pessoaRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // mostra uma pessoa especifica a partir do id
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Pessoa ende = pessoaRepository.findById(id);
        return ResponseEntity.ok().body(ende);
    }

}
