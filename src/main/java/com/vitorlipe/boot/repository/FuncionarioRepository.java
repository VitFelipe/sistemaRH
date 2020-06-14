package com.vitorlipe.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vitorlipe.boot.domain.Funcionario;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	@Query("SELECT f  FROM "+Funcionario.NAME+" f WHERE f.nome LIKE CONCAT('%',:nome,'%')")
	public List<Funcionario> buscarPorNome(String nome);

	
	
	@Query("SELECT f FROM "+Funcionario.NAME+" f WHERE f.cargo.id = :cargoId ")
	public List<Funcionario> buscarPorCargo(Long cargoId);

}
