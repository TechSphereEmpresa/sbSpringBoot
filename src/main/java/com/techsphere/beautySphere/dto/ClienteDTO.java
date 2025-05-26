package com.techsphere.beautySphere.dto;

import com.techsphere.beautySphere.model.Cliente;

public class ClienteDTO {

	public Long id;
	public String nome;
	public String telefone;

	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String nome, String telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;	
	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}
}
