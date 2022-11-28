package it.prova.agendarest.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.agendarest.dto.AgendaDTO;
import it.prova.agendarest.service.AgendaService;

@RestController
@RequestMapping("api/agenda")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	@GetMapping
	public List<AgendaDTO> listAll() {
		return AgendaDTO.createAgendaDTOListFromModelList(agendaService.findByUsername());
	}

	@GetMapping("/allAdmin")
	public List<AgendaDTO> listaAllAdmin() {
		return AgendaDTO.createAgendaDTOListFromModelList(agendaService.listAllElements(true));
	}
}
