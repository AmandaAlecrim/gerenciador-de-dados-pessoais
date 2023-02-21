package com.api.gerenciadordepessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gerenciadordepessoas.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
