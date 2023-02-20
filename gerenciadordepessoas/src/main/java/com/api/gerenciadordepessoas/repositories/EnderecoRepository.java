package com.api.gerenciadordepessoas.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.api.gerenciadordepessoas.entities.Endereco;

@Component
public class EnderecoRepository {

    private Map<Long, Endereco> map = new HashMap<>();

    public void save(Endereco obj) { // guardar endereços
        map.put(obj.getId(), obj);
    }

    public Endereco findById(Long id) { // buscar endereço pelo id
        return map.get(id);
    }

    public List<Endereco> findAll() { // mostrar todos os endereços
        return new ArrayList<Endereco>(map.values());
    }
}
