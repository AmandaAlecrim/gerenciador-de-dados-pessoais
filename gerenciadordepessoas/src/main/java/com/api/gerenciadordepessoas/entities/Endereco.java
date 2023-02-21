package com.api.gerenciadordepessoas.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String logradouro;
    private int cep;
    private int numero;
    private String cidade;
    private boolean principal;

    @JsonIgnore // para mostrar o código que não precisa serializar o objeto e evitar um looping
                // infinito.
    private Pessoa pessoa;

    public Endereco() {

    }

    public Endereco(Long id, String logradouro, int cep, int numero, String cidade, boolean principal, Pessoa pessoa) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.principal = principal;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}