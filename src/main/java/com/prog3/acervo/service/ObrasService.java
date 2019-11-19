package com.prog3.acervo.service;

import org.springframework.stereotype.Service;

import com.prog3.acervo.model.Obra;

@Service
public class ObrasService {

	public Obra replaceWhereNull(Obra obra, Obra obraBD) {
		obra.setId(obraBD.getId());
		obra.setAutor(compare(obra.getAutor(), obraBD.getAutor()));
		obra.setEdicao(compare(obra.getEdicao(), obraBD.getEdicao()));
		obra.setEditora(compare(obra.getEditora(), obraBD.getEditora()));
		obra.setIsbn(compare(obra.getIsbn(), obraBD.getIsbn()));
		obra.setIssn(compare(obra.getIssn(), obraBD.getIssn()));
		obra.setLocal(compare(obra.getLocal(), obraBD.getLocal()));
		obra.setPaginas(compare(obra.getPaginas(), obraBD.getPaginas()));
		obra.setTitulo(compare(obra.getTitulo(), obraBD.getTitulo()));
		return obra;
	}

	private String compare(String var, String var2) {
		String ret = (var == null) ? var2 : var;
		return ret;
	}

}
