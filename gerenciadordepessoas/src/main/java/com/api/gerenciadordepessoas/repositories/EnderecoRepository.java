package com.api.gerenciadordepessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gerenciadordepessoas.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
