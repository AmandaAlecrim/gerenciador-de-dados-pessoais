package com.api.gerenciadordepessoas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        Pessoa pes = pessoaRepository.findById(id).get();
        return ResponseEntity.ok().body(pes);
    }

    @PostMapping // adiciona uma pessoa
    public Pessoa adicionarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping // edita uma pessoa
    public Pessoa alterarPessoa(@RequestBody Pessoa pessoa) {
        if (pessoa.getId() > 0)
            return pessoaRepository.save(pessoa);
        return null;
    }

    @DeleteMapping("/{id}") // deleta uma pessoa
    public void deletarPessoa(@PathVariable(value = "id") Long id) {
        Pessoa p = pessoaRepository.findById(id).get();
        pessoaRepository.delete(p);
    }

}
