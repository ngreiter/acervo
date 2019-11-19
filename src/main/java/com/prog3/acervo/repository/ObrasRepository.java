package com.prog3.acervo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prog3.acervo.model.Obra;

@Repository
public interface ObrasRepository extends CrudRepository<Obra, Long> {

}
