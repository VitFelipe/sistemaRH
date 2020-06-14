package com.vitorlipe.boot.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.smartcardio.ATR;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vitorlipe.boot.domain.Cargo;
import com.vitorlipe.boot.domain.Funcionario;
import com.vitorlipe.boot.domain.SexoEnum;
import com.vitorlipe.boot.domain.UfEnum;
import com.vitorlipe.boot.service.CargoService;
import com.vitorlipe.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioServico;
	
	@Autowired
	private CargoService cargoService;
	
	
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		
		return new ModelAndView("funcionario/lista");
	}
	
	

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Funcionario funcionario) {
		
		return new ModelAndView("funcionario/cadastro");
	}
	
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "funcionario/cadastro";
		}
		
		funcionarioServico.salvar(funcionario);
		
		attributes.addFlashAttribute("sucesso", " Funcionario salvo com sucesso !");	
		return "redirect:/funcionarios/cadastrar";
	}
	
	
	
	@GetMapping("/excluir/{id}")
	public  String excluir(@PathVariable("id") Long id , RedirectAttributes attributes) {
		
		funcionarioServico.remover(id);
		
		attributes.addFlashAttribute("sucesso", "Funcionario excluido com sucesso !");
		
		return "redirect:/funcionarios/listar";
	}
	
	
	@PostMapping("/atualizar")
	public String atualizar( @Valid Funcionario funcionario , BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "funcionario/cadastro";
		}
		
		funcionarioServico.salvar(funcionario);
		
		attributes.addFlashAttribute("sucesso", "Funcionario atualizado com sucesso");
		
		return "redirect:/funcionarios/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	public ModelAndView preEditar(@PathVariable("id") Long id,ModelMap map) {
		
		map.addAttribute("funcionario", funcionarioServico.buscaPorId(id));
		
		return new  ModelAndView("funcionario/cadastro",map);	
	}
	
	
	
	@GetMapping("/buscar/nome")
	public ModelAndView buscarNome(@RequestParam("nome") String nome , ModelMap map) {
		
		List<Funcionario> funcionarios = funcionarioServico.buscaPorNome(nome);
		map.addAttribute("funcionarios",funcionarios);
		return new ModelAndView("funcionario/lista",map);
	}
	
	
	@GetMapping("/buscar/cargo")
	public ModelAndView buscarPorCargo(@RequestParam("cargoId") Long cargoId , ModelMap map ) {
		
		List<Funcionario> funcionarios  =  funcionarioServico.buscarPorCargo(cargoId);
		
		map.addAttribute("funcionarios",funcionarios);
		
		return new ModelAndView("funcionario/lista",map);
	}
	
	
	
	
	@ModelAttribute("funcionarios")
	public List<Funcionario> getFuncionarios(){
		return funcionarioServico.listaTodos();
	}
	
	
	
	
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoService.listaTodos();
	}
	
	
	
	
	@ModelAttribute("ufs")
	public List<UfEnum> getUfs(){
		return Arrays.asList(UfEnum.values());
	}
	
	
	
	
	@ModelAttribute("sexos")
	public List<SexoEnum> getSexos(){
		return Arrays.asList(SexoEnum.values());
	}
	
	
	
	
}
