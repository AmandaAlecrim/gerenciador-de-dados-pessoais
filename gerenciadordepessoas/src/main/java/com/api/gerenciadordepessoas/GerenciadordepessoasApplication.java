package com.api.gerenciadordepessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.gerenciadordepessoas.entities.Endereco;
import com.api.gerenciadordepessoas.repositories.EnderecoRepository;

@SpringBootApplication
public class GerenciadordepessoasApplication implements CommandLineRunner {

	@Autowired // injeta dependência
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadordepessoasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Endereco ende1 = new Endereco(1L, "Rua pipipi", 123456, 123, "florianópolis");
		Endereco ende2 = new Endereco(2L, "Rua popopo", 654321, 321, "biguaçu");

		enderecoRepository.save(ende1);
		enderecoRepository.save(ende2);
	}

}
