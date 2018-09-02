package com.hackathon.julius.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class MesExtrato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private LocalDate mesAno;

    @Column(nullable = false)
    private BigDecimal gastoTotal;

    @Column(nullable = false)
    private BigDecimal saldo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Usuario.class)
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("mesAno", mesAno)
                .append("gastoTotal", gastoTotal)
                .append("saldo", saldo)
                .append("usuario", usuario)
                .toString();
    }
}
