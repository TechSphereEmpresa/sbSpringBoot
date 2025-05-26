package com.techsphere.beautySphere.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Cliente result = clienteRepository.findById(id).get();
		ClienteDTO dto = new ClienteDTO(result);
		return dto;
	}
	
	public void addCliente(ClienteDTO dto) {
		clienteRepository.save(new Cliente(dto));
	}
	
	public void delete(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			clienteRepository.deleteById(id);
		}
	}
}
