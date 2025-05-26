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

import com.techsphere.beautySphere.dto.AgendamentoDTO;
import com.techsphere.beautySphere.service.AgendamentoService;

@RestController
@RequestMapping(value = "/agenda")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;
	
	@GetMapping
	public List<AgendamentoDTO> findAll() {
		List<AgendamentoDTO> result = agendamentoService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public AgendamentoDTO findById(@PathVariable Long id) {
		AgendamentoDTO result = agendamentoService.findById(id);
		return result;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		try {
			agendamentoService.delete(id);
			return ResponseEntity.ok().body("Item removido com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro inesperado");
		}
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<Object> add(@RequestBody AgendamentoDTO dto) {
		try {
			agendamentoService.addAgendamento(dto);
			return ResponseEntity.ok().body("Item adicionado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro inesperado");
		}
	}
	
}
