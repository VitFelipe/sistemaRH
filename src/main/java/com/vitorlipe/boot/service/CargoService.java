package com.vitorlipe.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlipe.boot.domain.Cargo;
import com.vitorlipe.boot.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	public Cargo salvar(Cargo cargo) {
		cargoRepository.save(cargo);
		return cargo;
	}

	public List<Cargo> listaTodos() {
		return cargoRepository.findAll();
	}

	public void remover(Long id) {
		Cargo cargo  =  cargoRepository.getOne(id);
		 
		 if(!cargo.getFuncionarios().isEmpty()) {
			 throw new RuntimeException("Você não pode excluir um cargo vinculado à funcionario!");
		 }
		cargoRepository.deleteById(id);
	}

	public Cargo buscaPorId(Long id) {
		return cargoRepository.getOne(id);
	}
	
	

}
