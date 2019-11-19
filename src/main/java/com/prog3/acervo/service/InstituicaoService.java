package com.prog3.acervo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog3.acervo.model.Instituicao;
import com.prog3.acervo.repository.InstituicaoRepository;

@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	public Instituicao replaceWhereNull(Instituicao instituicao, Instituicao instituicaoBD) {
		instituicao.setEntidade(this.compare(instituicao.getEntidade(), instituicaoBD.getEntidade()));
		instituicao.setNome(this.compare(instituicao.getNome(), instituicaoBD.getNome()));
		instituicao.setId(instituicaoBD.getId());
		return instituicao;
	}

	private String compare(String var, String var2) {
		String ret = (var == null) ? var2 : var;
		return ret;
	}

	public List<Instituicao> getAllInstituicao() {
		Iterable<Instituicao> instituicaoList = instituicaoRepository.findAll();
		List<Instituicao> returnList = new ArrayList<>();
		instituicaoList.forEach(instituicao -> returnList.add(instituicao));
		return returnList;
	}

}
