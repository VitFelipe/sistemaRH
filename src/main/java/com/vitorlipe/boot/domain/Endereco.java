package com.vitorlipe.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name=Endereco.NAME)
@Table(name="endereco")
public class Endereco extends AbstractEntity<Long>{
	
	public static final String NAME= "demo_endereco";
	
	@NotBlank
	@Column(nullable = false)
	private String logradouro;
	
	@NotBlank
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank
	@Column(nullable = false)
	private String cidade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable =  false , length = 2)
	private UfEnum uf;
	

	private String complemento;
	
	@NotNull
	@Size(max = 9, min = 9)
	@Column(nullable = false,length =   9)
	private String cep;
	
	@NotNull
	@Column(nullable = false, length = 5)
	private Integer numero;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UfEnum getUf() {
		return uf;
	}

	public void setUf(UfEnum uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
