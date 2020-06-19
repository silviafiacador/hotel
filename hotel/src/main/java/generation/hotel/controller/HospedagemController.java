package generation.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generation.hotel.model.Hospedagem;
import generation.hotel.repository.HospedagemRepository;

@RestController
@RequestMapping("/hospedagem")
@CrossOrigin("*")
public class HospedagemController {
	
	@Autowired
	private HospedagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Hospedagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}

}
