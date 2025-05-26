package com.techsphere.beautySphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
