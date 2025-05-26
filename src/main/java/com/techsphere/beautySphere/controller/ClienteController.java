package com.techsphere.beautySphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
