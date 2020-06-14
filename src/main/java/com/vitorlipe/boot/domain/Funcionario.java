package com.vitorlipe.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity(name=Funcionario.NAME)
@Table(name = "funcionarios")
public class Funcionario extends AbstractEntity<Long> {
	
	public static final String NAME= "demo_funcionario";
	
	@NotBlank
	@Size(min = 3 , max = 80)
	@Column(name = "nome",nullable = false,unique = true)
	private String nome;
	
	@NotNull
	@NumberFormat(pattern = "#,##0.00",style = Style.CURRENCY)
	@Column(nullable = false, columnDefinition = "decimal(7,2) default 0.00")
	private BigDecimal  salario;
	
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_entrada",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_saida",nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataSaida;
	
	
	@Valid
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	
	
	@NotNull(message = "{NotNull.funcionario.cargo.message}")
	@ManyToOne
	@JoinColumn(name = "cargo_id_fk")
	private Cargo cargo ;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo",nullable = false)
	private SexoEnum sexo;
	
	public SexoEnum getSexo() {
		return sexo;
	}
	
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	
	

}
