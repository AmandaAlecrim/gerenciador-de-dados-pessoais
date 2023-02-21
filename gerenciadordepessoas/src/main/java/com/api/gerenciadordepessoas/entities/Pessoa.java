package com.api.gerenciadordepessoas.entities;

import java.io.Serializable;
import java.util.List;

import java.util.ArrayList;

public class Pessoa implements Serializable {

    private static final long serialVerisonUID = 1L;

    private Long id;
    private String name;
    private String nascimento;

    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa() {

    }

    public Pessoa(Long id, String name, String nascimento) {
        this.id = id;
        this.name = name;
        this.nascimento = nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    // Uso de hashCode e equals para fazer a comparação entre os ids de endereço.
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
