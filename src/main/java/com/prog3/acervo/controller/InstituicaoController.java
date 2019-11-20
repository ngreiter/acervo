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

import com.prog3.acervo.model.Instituicao;
import com.prog3.acervo.repository.InstituicaoRepository;
import com.prog3.acervo.service.InstituicaoService;

@Controller
public class InstituicaoController {

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	@Autowired
	private InstituicaoService instituicaoService;

	@GetMapping("/instituicao/{id}")
	public ResponseEntity<Instituicao> getOne(long id) {
		Optional<Instituicao> instituicao = instituicaoRepository.findById(id);
		return ResponseEntity.ok(instituicao.get());
	}

	@GetMapping("/instituicao")
	public ResponseEntity<List<Instituicao>> getAll() {
		List<Instituicao> returnList = instituicaoService.getAllInstituicao();
		return ResponseEntity.ok(returnList);
	}

	@PostMapping("/instituicao")
	public ResponseEntity<Instituicao> add(@RequestBody Instituicao instituicao) {
		instituicaoRepository.save(instituicao);
		return ResponseEntity.ok(instituicao);
	}

	@PutMapping("/instituicao/{id}")
	public ResponseEntity<Instituicao> update(@RequestBody Instituicao instituicao, @PathVariable long id) {
		instituicao = instituicaoService.replaceWhereNull(instituicao, instituicaoRepository.findById(id).get());
		instituicaoRepository.save(instituicao);
		return ResponseEntity.ok(instituicao);
	}

	@DeleteMapping("/instituicao/{id}")
	public ResponseEntity<String> deletePorId(long id) {
		instituicaoRepository.deleteById(id);
		return ResponseEntity.ok("instituição removida");
	}

}
