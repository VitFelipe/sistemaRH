package com.vitorlipe.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlipe.boot.domain.Endereco;
import com.vitorlipe.boot.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco salvar(Endereco endereco) {
		enderecoRepository.save(endereco);
		return endereco;
	}

	public List<Endereco> listaTodos() {
		return enderecoRepository.findAll();
	}

	public void remover(Long id) {
		enderecoRepository.deleteById(id);
	}

	public Endereco buscaPorId(Long id) {
		return enderecoRepository.getOne(id);
	}

}
