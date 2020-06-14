package com.vitorlipe.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlipe.boot.domain.Funcionario;
import com.vitorlipe.boot.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario;
	}

	public List<Funcionario> listaTodos() {
		return funcionarioRepository.findAll();
	}

	public void remover(Long id) {
		funcionarioRepository.deleteById(id);
	}

	public Funcionario buscaPorId(Long id) {
		return funcionarioRepository.getOne(id);
	}

	public List<Funcionario> buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		return funcionarioRepository.buscarPorNome(nome);
	}

	public List<Funcionario> buscarPorCargo(Long cargoId) {
	
		return funcionarioRepository.buscarPorCargo(cargoId);
	}

}
