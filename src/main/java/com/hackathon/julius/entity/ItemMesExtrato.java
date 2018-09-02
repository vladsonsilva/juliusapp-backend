package com.hackathon.julius.entity;

import com.hackathon.julius.entity.enums.TipoItemEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemMesExtrato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MesExtrato mesExtrato;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoItemEnum tipo;

    @Column(nullable = false)
    private BigDecimal valor;

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

    public MesExtrato getMesExtrato() {
        return mesExtrato;
    }

    public void setMesExtrato(MesExtrato mesExtrato) {
        this.mesExtrato = mesExtrato;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("tipo", tipo)
                .append("valor", valor)
                .toString();
    }
}
