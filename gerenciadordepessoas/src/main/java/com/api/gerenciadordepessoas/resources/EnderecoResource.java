package com.api.gerenciadordepessoas.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gerenciadordepessoas.entities.Endereco;

@RestController // Para o springboot reconhecer a classe como um resource
@RequestMapping(value = "/enderecos") // Definindo o caminho de saída como "localhost:8080/enderecos"
public class EnderecoResource {
    @GetMapping // mostra todos os enderecos em forma de lista por meio de requisição GET
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> list = new ArrayList<>();
        list.add(new Endereco(1L, "Rua pipipi", 123456, 123, "florianópolis"));
        list.add(new Endereco(2L, "Rua popopo", 654321, 321, "biguacu"));
        return ResponseEntity.ok().body(list);
    }
    /*
     * @GetMapping(value = "/{id}")
     * public ResponseEntity<> findById(@PathVariable Long id) {
     * 
     * return ResponseEntity.ok().body();
     * }
     */
}
