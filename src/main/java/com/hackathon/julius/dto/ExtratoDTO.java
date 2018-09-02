package com.hackathon.julius.dto;

import com.hackathon.julius.entity.ItemMesExtrato;
import com.hackathon.julius.entity.MesExtrato;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExtratoDTO {
    private Integer id;
    private LocalDate mesAno;
    private BigDecimal gastoTotal;
    private BigDecimal saldo;
    private List<ItemExtratoDTO> items;

    public static ExtratoDTO build(MesExtrato mesExtratoEntidade, List<ItemMesExtrato> itensMesExtrato) {
        ExtratoDTO extratoDTO = new ExtratoDTO();
        extratoDTO.setId(mesExtratoEntidade.getId());
        extratoDTO.setMesAno(mesExtratoEntidade.getMesAno());
        extratoDTO.setGastoTotal(mesExtratoEntidade.getGastoTotal());
        extratoDTO.setSaldo(mesExtratoEntidade.getSaldo());

        List<ItemExtratoDTO> itemsExtrato = new ArrayList<>();
        for (ItemMesExtrato itemMesExtrato : itensMesExtrato) {
            itemsExtrato.add(ItemExtratoDTO.build(itemMesExtrato));
        }
        extratoDTO.setItems(itemsExtrato);

        return extratoDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getMesAno() {
        return mesAno;
    }

    public void setMesAno(LocalDate mesAno) {
        this.mesAno = mesAno;
    }

    public BigDecimal getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(BigDecimal gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<ItemExtratoDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemExtratoDTO> items) {
        this.items = items;
    }
}
