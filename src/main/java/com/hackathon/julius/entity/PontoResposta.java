package com.hackathon.julius.entity;

import com.hackathon.julius.entity.enums.TipoPerfil;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PontoResposta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPerfil tipoPerfil;

    @Column(nullable = false)
    private BigDecimal total;
    PontoResposta(){}

    public PontoResposta(Integer id, TipoPerfil tipoPerfil, BigDecimal total) {
        this.id = id;
        this.tipoPerfil = tipoPerfil;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("tipoPerfil", tipoPerfil)
                .append("total", total)
                .toString();
    }
}
