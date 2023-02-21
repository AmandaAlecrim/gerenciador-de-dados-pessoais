package com.api.gerenciadordepessoas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gerenciadordepessoas.entities.Endereco;
import com.api.gerenciadordepessoas.repositories.EnderecoRepository;

@RestController // Para o springboot reconhecer a classe como um resource
@RequestMapping(value = "/enderecos") // Definindo o caminho de saída como "localhost:8080/enderecos"
public class EnderecoResource {

    @Autowired // injeta dependência
    private EnderecoRepository enderecoRepository;

    @GetMapping // mostra todos os enderecos em forma de lista por meio de requisição GET
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> list = enderecoRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // mostra um endereco especifico a partir do id
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Endereco ende = enderecoRepository.findById(id).get();
        return ResponseEntity.ok().body(ende);
    }

    @PostMapping // adiciona um endereço
    public Endereco adicionarEndereco(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @PutMapping // edita um endereço
    public Endereco alterarEndereco(@RequestBody Endereco endereco) {
        if (endereco.getId() > 0)
            return enderecoRepository.save(endereco);
        return null;
    }

    @DeleteMapping("/{id}") // deleta um endereço
    public void deletarEndereco(@PathVariable(value = "id") Long id) {
        Endereco e = enderecoRepository.findById(id).get();
        enderecoRepository.delete(e);
    }

}
