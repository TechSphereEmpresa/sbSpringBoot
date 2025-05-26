package com.techsphere.beautySphere.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true)
	public AgendamentoDTO findById(Long id) {
		Agendamento result = agendamentoRepository.findById(id).get();
		AgendamentoDTO dto = new AgendamentoDTO(result);
		return dto;
	}
	
	public void addAgendamento(AgendamentoDTO dto) {
		agendamentoRepository.save(new Agendamento(dto));
	}
	
	public void delete(Long id) {
		Optional<Agendamento> optional = agendamentoRepository.findById(id);
		if (optional.isPresent()) {
			agendamentoRepository.deleteById(id);
		}
	}
	
}
