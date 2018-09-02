package com.hackathon.julius.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataEstipulada;

    @Column(nullable = false)
    private Double valorEstipulado;

    @Column(nullable = false)
    private Double valorInvestido;

    @ManyToOne
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEstipulada() {
        return dataEstipulada;
    }

    public void setDataEstipulada(LocalDate dataEstipulada) {
        this.dataEstipulada = dataEstipulada;
    }

    public Double getValorEstipulado() {
        return valorEstipulado;
    }

    public void setValorEstipulado(Double valorEstipulado) {
        this.valorEstipulado = valorEstipulado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("descricao", descricao)
                .append("dataEstipulada", dataEstipulada)
                .append("valorEstipulado", valorEstipulado)
                .append("valorInvestido", valorInvestido)
                .append("usuario", usuario)
                .toString();
    }
}
