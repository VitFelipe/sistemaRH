package com.vitorlipe.boot.web.erro;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ErroView implements ErrorViewResolver  {

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		ModelAndView modelAndView =  new ModelAndView("error");
		
		modelAndView.addObject("status", status.value());
		
		switch (status.value()) {
		case 404:
			modelAndView.addObject("error", "Pagina não encontrada");
			modelAndView.addObject("message",  "A Pagina da url '"+model.get("path")+"' não foi encontrada");
			break;
		case 500:
			modelAndView.addObject("error", "Ops, aconteceu um erro interno");
			modelAndView.addObject("message",  "Um erro inesperado aconteceu , tente novamente mas tarde.");
			break;	

		default:
	
			modelAndView.addObject("error", model.get("error"));
			modelAndView.addObject("message", model.get("message") );

		}
		
		return modelAndView;
	}

}
