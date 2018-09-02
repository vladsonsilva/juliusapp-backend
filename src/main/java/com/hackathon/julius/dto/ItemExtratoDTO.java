package com.hackathon.julius.dto;

import com.hackathon.julius.entity.ItemMesExtrato;
import com.hackathon.julius.entity.enums.TipoItemEnum;

import java.math.BigDecimal;

public class ItemExtratoDTO {
    private Integer id;
    private TipoItemEnum tipo;
    private BigDecimal valor;

    public static ItemExtratoDTO build(ItemMesExtrato entidade) {
        ItemExtratoDTO item = new ItemExtratoDTO();
        item.setId(entidade.getId());
        item.setTipo(entidade.getTipo());
        item.setValor(entidade.getValor());

        return item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoItemEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoItemEnum tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
