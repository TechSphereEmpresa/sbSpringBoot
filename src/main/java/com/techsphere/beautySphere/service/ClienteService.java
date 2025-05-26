package com.techsphere.beautySphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsphere.beautySphere.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
//	public List<AgendamentoDTO> findAll() {
//		
//		return 
//	}
	
//	public List<TarefaDto> findAll() {
//		List<Tarefa> listaTarefas = tarefaRepository.findAll();
//		return listaTarefas.stream().map(
//			tarefa -> new TarefaDto(tarefa)
//		).collect(Collectors.toList());
//	}
}
