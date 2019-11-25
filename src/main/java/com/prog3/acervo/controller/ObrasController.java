package com.prog3.acervo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prog3.acervo.model.Obra;
import com.prog3.acervo.repository.ObrasRepository;
import com.prog3.acervo.service.ObrasService;

@Controller
public class ObrasController {

	@Autowired
	private ObrasRepository obrasRepository;

	@Autowired
	private ObrasService obrasService;

	@GetMapping("/obras/{id}")
	public ResponseEntity<Obra> getObra(@PathVariable long id) {
		Optional<Obra> obra = obrasRepository.findById(id);
		return ResponseEntity.ok(obra.get());
	}

	@GetMapping("/obras")
	public ResponseEntity<List<Obra>> getAll() {
		List<Obra> returnList = obrasService.getAllObras();
		return ResponseEntity.ok(returnList);
	}

	@PostMapping("/obras")
	public ResponseEntity<Obra> add(@RequestBody Obra obra) {
		obrasRepository.save(obra);
		return ResponseEntity.ok(obra);
	}

	@PutMapping("/obras/{id}")
	public ResponseEntity<Obra> update(@RequestBody Obra obra, @PathVariable long id) {
		obra = obrasService.replaceWhereNull(obra, obrasRepository.findById(id).get());
		obrasRepository.save(obra);
		return ResponseEntity.ok(obra);
	}

	@DeleteMapping("/obras/{id}")
	public ResponseEntity<String> deletePorId(@PathVariable long id) {
		obrasRepository.deleteById(id);
		return ResponseEntity.ok("obra removida");
	}

	@DeleteMapping("/obras")
	public ResponseEntity<String> delete(@RequestBody String titulo) {
		obrasService.deleteByTitulo(titulo);
		return ResponseEntity.ok("obra(s) removida(s)");
	}

}
