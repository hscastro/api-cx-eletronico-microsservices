package com.hscastro.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hscastro.app.entities.Cliente;
import com.hscastro.app.feignClients.ClienteFeignClient;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteFeignClient serviceFeignClient;
	
	//@PostMapping(value = "/salvar", produces = {"application/json"}, consumes = {"application/x-www-form-urlencoded"})
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public String cadastrar(Cliente cliente) {
		return "clientes/cadastro";
	}
	
	@PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = { MediaType.APPLICATION_JSON_VALUE})
	public String salvar(Cliente cliente, RedirectAttributes attr) {
		 serviceFeignClient.save(cliente);
		 attr.addFlashAttribute("success", "Cliente inserido com sucesso.");
			return "redirect:/clientes/cadastro";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		Cliente cli = serviceFeignClient.findById(id).getBody();
		model.addAttribute("cliente", cli);
		return "clientes/cadastro";
	}	
	
	@PutMapping(value = "/editar", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = { MediaType.APPLICATION_JSON_VALUE})
	public String editar(Cliente cliente, RedirectAttributes attr) {
		 serviceFeignClient.update(cliente);
		 attr.addFlashAttribute("success", "Cliente atualizado com sucesso.");
			return "redirect:/clientes/cadastro";
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Cliente> findById(@PathVariable Long id){	
		
		Cliente objCliente = serviceFeignClient.findById(id).getBody();
		return ResponseEntity.ok(objCliente);		
	}	
	
	@GetMapping("/lista")
	public String listar(ModelMap model) {
		List<Cliente> clientes = serviceFeignClient.findAll();
		model.addAttribute("clientes", clientes);
		return "clientes/lista";		
	}
		
		
}
