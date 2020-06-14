package com.vitorlipe.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity(name = Departamento.NAME)
@Table(name = "departamentos")
public class Departamento extends AbstractEntity<Long> {
	
	public static final String NAME= "demo_departamento";
	
	@NotBlank(message = "Informe o nome do departamento !")
	@Size(max = 80 ,  min = 3 , message = "Informe um nome que esteja esteje entre {min} e {max} caracteres !")
	@Column(name = "nome",unique = true ,length = 60, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "departamento",fetch = FetchType.LAZY)
	private List<Cargo> cargos;
	

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
	
	
	
	

}
