package com.vitorlipe.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.vitorlipe.boot.domain.Departamento;
import com.vitorlipe.boot.service.DepartamentoService;

public class DepartamentoConverter implements Converter<String,Departamento> {
	
	@Autowired
	private DepartamentoService departamentoService;

	@Override
	public Departamento convert(String text) {
		
		System.out.println(text);
		
		if(text == null) {
			return null;
		}
		return departamentoService.buscaPorId(Long.parseLong(text)) ;
	}

}
