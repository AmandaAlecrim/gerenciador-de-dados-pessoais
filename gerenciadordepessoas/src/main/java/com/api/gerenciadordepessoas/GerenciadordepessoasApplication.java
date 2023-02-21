package com.api.gerenciadordepessoas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.gerenciadordepessoas.entities.Endereco;
import com.api.gerenciadordepessoas.entities.Pessoa;
import com.api.gerenciadordepessoas.repositories.EnderecoRepository;
import com.api.gerenciadordepessoas.repositories.PessoaRepository;

@SpringBootApplication
public class GerenciadordepessoasApplication implements CommandLineRunner {

	@Autowired // injeta dependência
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadordepessoasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Pessoa pes1 = new Pessoa(null, "Roberto", "2000-07-14");
		Pessoa pes2 = new Pessoa(null, "José", "2000-07-14");

		Endereco ende1 = new Endereco(null, "Rua pipipi", 123456, 123, "florianópolis", true, pes1);
		Endereco ende2 = new Endereco(null, "Rua popopo", 654321, 321, "biguaçu", true, pes2);
		Endereco ende3 = new Endereco(null, "Rua papapa", 246810, 246, "wonderland", false, pes1);
		pes1.getEnderecos().addAll(Arrays.asList(ende1, ende3));
		pes2.getEnderecos().addAll(Arrays.asList(ende2));

		pessoaRepository.save(pes1);
		pessoaRepository.save(pes2);

		enderecoRepository.save(ende1);
		enderecoRepository.save(ende2);
		enderecoRepository.save(ende3);

	}

}
