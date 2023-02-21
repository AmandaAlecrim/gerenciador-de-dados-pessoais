package com.api.gerenciadordepessoas.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.api.gerenciadordepessoas.entities.Pessoa;

@Component
public class PessoaRepository {

    private Map<Long, Pessoa> map = new HashMap<>();

    public void save(Pessoa obj) { // guardar endereços
        map.put(obj.getId(), obj);
    }

    public Pessoa findById(Long id) { // buscar endereço pelo id
        return map.get(id);
    }

    public List<Pessoa> findAll() { // mostrar todos os endereços
        return new ArrayList<Pessoa>(map.values());
    }

}
