package com.hackathon.julius.repository;

import com.hackathon.julius.entity.ItemMesExtrato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemMesExtratoRepository extends CrudRepository<ItemMesExtrato, Integer> {
    List<ItemMesExtrato> findByMesExtratoId(Integer id);
}
