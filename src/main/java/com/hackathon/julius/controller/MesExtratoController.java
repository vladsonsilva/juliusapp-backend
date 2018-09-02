package com.hackathon.julius.controller;

import com.hackathon.julius.dto.ExtratoDTO;
import com.hackathon.julius.entity.ItemMesExtrato;
import com.hackathon.julius.entity.MesExtrato;
import com.hackathon.julius.repository.ItemMesExtratoRepository;
import com.hackathon.julius.repository.MesExtratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MesExtratoController {
    @Autowired
    private MesExtratoRepository mesExtratoRepository;

    @Autowired
    private ItemMesExtratoRepository itemMesExtratoRepository;

    @GetMapping(path = "usuarios/{userId}/extratos")
    public List<ExtratoDTO> list(@PathVariable("userId") Integer userId) {
        List<ExtratoDTO> extratos = new ArrayList<>();

        List<MesExtrato> mesExtratos = mesExtratoRepository.findByUsuarioId(userId);
        for (MesExtrato mesExtrato : mesExtratos) {
            List<ItemMesExtrato> itensMesExtrato = itemMesExtratoRepository.findByMesExtratoId(mesExtrato.getId());
            extratos.add(ExtratoDTO.build(mesExtrato, itensMesExtrato));
        }

        return extratos;
    }
}
