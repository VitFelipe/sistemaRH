package com.vitorlipe.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = Cargo.NAME)
@Table(name = "cargos")
public class Cargo  extends AbstractEntity<Long> {
	
	public static final String NAME = "demo_cargo";
	


	@NotBlank(message = "Informe o nome do cargo !")
	@Size(max = 80 , min = 3 , message = "Infome um nome que esteja entre {min} e {max} caracteres!")
	@Column(name = "nome" , nullable = false , unique = true)
	private String nome;
	
	
	@NotNull(message = "Informe o departamento")
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	private Departamento departamento;
	
	
	@OneToMany(mappedBy = "cargo",fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;
	
	
	
	
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	


}
