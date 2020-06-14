package com.vitorlipe.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlipe.boot.domain.Departamento;


@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
	

}
