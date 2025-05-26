package com.techsphere.beautySphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsphere.beautySphere.dto.AgendamentoDTO;
import com.techsphere.beautySphere.model.Agendamento;
import com.techsphere.beautySphere.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<AgendamentoDTO> findAll() {
		List<Agendamento> listaAgendamentos = agendamentoRepository.findAll();
		List<AgendamentoDTO> dto = listaAgendamentos.stream().map(x -> new AgendamentoDTO(x)).toList();
		return dto;
	}
}
