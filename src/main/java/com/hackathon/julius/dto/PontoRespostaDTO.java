package com.hackathon.julius.dto;

import com.hackathon.julius.entity.enums.TipoPerfil;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class PontoRespostaDTO {

    private TipoPerfil tipoPerfil;

    private Double total;


    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tipoPerfil", tipoPerfil)
                .append("total", total)
                .toString();
    }
}
