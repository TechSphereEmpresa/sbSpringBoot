package com.techsphere.beautySphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsphere.beautySphere.dto.ClienteDTO;
import com.techsphere.beautySphere.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<ClienteDTO> findAll() {
		List<ClienteDTO> result = clienteService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public ClienteDTO findById(@PathVariable Long id) {
		ClienteDTO result = clienteService.findById(id);
		return result;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		try {
			clienteService.delete(id);
			return ResponseEntity.ok().body("Item removido com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro inesperado");
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(@RequestBody ClienteDTO dto) {
		try {
			clienteService.addCliente(dto);
			return ResponseEntity.ok().body("Item adicionado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro inesperado");
		}
	}
}
