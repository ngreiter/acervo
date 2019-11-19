package com.prog3.acervo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog3.acervo.model.Obra;
import com.prog3.acervo.repository.ObrasRepository;

@Service
public class ObrasService {

	@Autowired
	private ObrasRepository obrasRepository;

	public Obra replaceWhereNull(Obra obra, Obra obraBD) {
		obra.setAutor(this.compare(obra.getAutor(), obraBD.getAutor()));
		obra.setEdicao(this.compare(obra.getEdicao(), obraBD.getEdicao()));
		obra.setEditora(this.compare(obra.getEditora(), obraBD.getEditora()));
		obra.setIsbn(this.compare(obra.getIsbn(), obraBD.getIsbn()));
		obra.setIssn(this.compare(obra.getIssn(), obraBD.getIssn()));
		obra.setLocal(this.compare(obra.getLocal(), obraBD.getLocal()));
		obra.setPaginas(this.compare(obra.getPaginas(), obraBD.getPaginas()));
		obra.setTitulo(this.compare(obra.getTitulo(), obraBD.getTitulo()));
		obra.setId(obraBD.getId());
		return obra;
	}

	private String compare(String var, String var2) {
		String ret = (var == null) ? var2 : var;
		return ret;
	}

	public List<Obra> getAllObras() {
		Iterable<Obra> obras = obrasRepository.findAll();
		List<Obra> returnList = new ArrayList<>();
		obras.forEach(obra -> returnList.add(obra));
		return returnList;
	}

	public void deleteByTitulo(String titulo) {
		obrasRepository.findAll().forEach(obra -> {
			if (obra.getTitulo().equals(titulo)) {
				obrasRepository.delete(obra);
			}
		});
	}

}
