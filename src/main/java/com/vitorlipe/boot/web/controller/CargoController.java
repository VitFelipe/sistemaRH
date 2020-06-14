package com.vitorlipe.boot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vitorlipe.boot.domain.Cargo;
import com.vitorlipe.boot.domain.Departamento;
import com.vitorlipe.boot.service.CargoService;
import com.vitorlipe.boot.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private CargoService cargoService;

	
	
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		
		return new ModelAndView("cargo/lista");
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Cargo cargo ) {
		
		return new ModelAndView("cargo/cadastro");
	}
	
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo , BindingResult result , RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		cargoService.salvar(cargo);
		
		redirectAttributes.addFlashAttribute("sucesso","Cargo salvo com sucesso!");
		
		return "redirect:/cargos/cadastrar";
	}
	
	
	
	
	@GetMapping("/editar/{id}")
	public ModelAndView preEditar(@PathVariable("id") Long id , ModelMap modelMap) {
		
		modelMap.addAttribute("cargo",cargoService.buscaPorId(id));
		
			return new  ModelAndView("cargo/cadastro",modelMap);
					
	}
	
	
	@PostMapping("/atualizar")
	public String atualizar(@Valid Cargo cargo ,  BindingResult result  , RedirectAttributes redirectAttributes) {
		
		
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		
		/*
		 * Atualizando Cargo
		 */
		cargoService.salvar(cargo);
		
		redirectAttributes.addFlashAttribute("sucesso","Cargo atualizado com sucesso !");
		
		return "redirect:/cargos/listar";
	}
	
	
	
	
	

	@GetMapping("/excluir/{id}")
   public String  excluir(@PathVariable("id") Long id , RedirectAttributes redirectAttributes ) {
	
		try {
			
			cargoService.remover(id);
			
			redirectAttributes.addFlashAttribute("sucesso", "Cargo excluido com sucesso");
		}catch(Exception e) {
			redirectAttributes.addAttribute("erro", e.getMessage());
		}
	 		
		 return "redirect:/cargos/listar";
	 }
	
	
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos(){
		return departamentoService.listaTodos();
	}
	
	
	@ModelAttribute("cargos")
	public List<Cargo> listaDeCargos(){
		return cargoService.listaTodos();
	}
	
}
