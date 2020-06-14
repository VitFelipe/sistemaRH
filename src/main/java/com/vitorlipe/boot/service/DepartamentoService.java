package com.vitorlipe.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlipe.boot.domain.Departamento;
import com.vitorlipe.boot.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	public Departamento salvar(Departamento depatamento) {
		departamentoRepository.save(depatamento);
		return depatamento;
	}
	
	
	
	public List<Departamento> listaTodos() {
	 return departamentoRepository.findAll();
	}
	
	
	
	
	public void remover(Long id ) {
		departamentoRepository.deleteById(id);
	}
	
	
	
	public Departamento buscaPorId(Long id) {
		return departamentoRepository.getOne(id);
	}



	public boolean temCargos(Long id) {
		
		return departamentoRepository.getOne(id).getCargos().size() > 0;
	}
	
}
