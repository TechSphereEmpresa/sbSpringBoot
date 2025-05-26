package com.techsphere.beautySphere.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.techsphere.beautySphere.model.Agendamento;
import com.techsphere.beautySphere.model.Cliente;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AgendamentoDTO {

	public Long id;
	public LocalDate data;
	public LocalTime hora;
	public String servico;
	 
	@ManyToOne
    @JoinColumn(name = "cliente_id")
	public Cliente cliente;
	
	public AgendamentoDTO() {
	}

	public AgendamentoDTO(Long id, LocalDate data, LocalTime hora, String servico, Cliente cliente) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.servico = servico;
		this.cliente = cliente;
	}

	public AgendamentoDTO(Agendamento agendamento) {
		super();
		this.id = agendamento.getId();
		this.data = agendamento.getData();
		this.hora = agendamento.getHora();
		this.servico = agendamento.getServico();
		this.cliente = agendamento.getCliente();
	}
}
