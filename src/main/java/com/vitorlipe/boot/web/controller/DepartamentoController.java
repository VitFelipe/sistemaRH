package com.vitorlipe.boot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vitorlipe.boot.domain.Departamento;
import com.vitorlipe.boot.service.DepartamentoService;

@Controller
@RequestMapping("departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/listar")
	public ModelAndView lista(ModelMap modelMap) {

		List<Departamento> departamentos = departamentoService.listaTodos();

		modelMap.addAttribute("departamentos", departamentos);

		return new ModelAndView("departamento/lista");
	}
	
	
	
	

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Departamento departamento) {

		return new ModelAndView("departamento/cadastro");
	}
	
	
	

	@PostMapping("/salvar")
	public String salvar(@Valid Departamento departamento , BindingResult bindingResult ,RedirectAttributes redirectAttributes) {

		System.out.println(bindingResult.hasErrors());
		
		if(bindingResult.hasErrors()) {
			return "departamento/cadastro";
		}
		
		departamentoService.salvar(departamento);
		
		redirectAttributes.addFlashAttribute("sucesso", "Departamento salvo com sucesso !");

		return "redirect:/departamentos/cadastrar";
	}
	
	
	
	

	@GetMapping("/editar/{id}")
	public ModelAndView preEditar(@PathVariable("id") Long id, ModelMap modelMap) {
		Departamento departamento = departamentoService.buscaPorId(id);
		modelMap.addAttribute("departamento", departamento);

		return new ModelAndView("departamento/cadastro", modelMap);
	}
	
	
	
	

	@PostMapping("/editar")
	public String editar(@Valid Departamento departamento, BindingResult
			 bindingResult ,RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return "deparatamento/cadastro";
		}

		departamentoService.salvar(departamento);
		
		redirectAttributes.addFlashAttribute("sucesso", "Departamento atualizado com sucesso !");

		return "redirect:/departamentos/listar";
	}
	
	
	
	

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, ModelMap model) {

		if (!departamentoService.temCargos(id)) {
			departamentoService.remover(id);
			model.addAttribute("sucesso", "Departamento excluido com sucesso !");
		}else {
			model.addAttribute("erro", "Você não pode excluir um departamento que possui cargos vinculados !");
		}
		
		

		return lista(model);
	}
	
	
	

}
