package com.hackathon.julius.repository;

import com.hackathon.julius.entity.MesExtrato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MesExtratoRepository extends CrudRepository<MesExtrato, Integer> {
    List<MesExtrato> findByUsuarioId(Integer userId);
}
