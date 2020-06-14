package com.vitorlipe.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.vitorlipe.boot.domain.Cargo;
import com.vitorlipe.boot.service.CargoService;

public class CargoConverter implements Converter<String, Cargo> {
	
	@Autowired
	private CargoService cargoService;

	@Override
	public Cargo convert(String value) {
		// TODO Auto-generated method stub
		try {
		if(value == null ) {
			return null;
		}
		 
		return cargoService.buscaPorId(Long.parseLong(value));
		
		}catch(Exception e) {
			return null;
		}
	}
	
	

}
