package com.techsphere.beautySphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsphere.beautySphere.dto.ClienteDTO;
import com.techsphere.beautySphere.model.Cliente;
import com.techsphere.beautySphere.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDTO> findAll() {
		List<Cliente> listaClientes = clienteRepository.findAll();
		List<ClienteDTO> dto = listaClientes.stream().map(x -> new ClienteDTO(x)).toList();
		return dto;
	}
}
