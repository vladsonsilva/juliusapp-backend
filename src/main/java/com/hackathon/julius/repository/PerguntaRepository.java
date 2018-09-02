package com.hackathon.julius.repository;

import com.hackathon.julius.entity.Pergunta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PerguntaRepository extends CrudRepository<Pergunta, Integer> {

    public List<Pergunta> findAll();
}
