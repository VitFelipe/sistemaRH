package com.vitorlipe.boot.domain;

public enum SexoEnum {
	
	MASCULINO("Masculino"),FEMININO("Femilino");
	
	private String descricao;
	
	private SexoEnum(String descricao) {
		
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
