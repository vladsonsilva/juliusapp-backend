package com.hackathon.julius.entity;

import com.hackathon.julius.entity.enums.TipoPerfil;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true)
    private String usuario;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String numeroCartao;

    @Column(nullable = false)
    private BigDecimal renda;

    @Column(nullable = false)
    private BigDecimal gastoFixo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPerfil tipoPerfil;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    public Usuario() { }

    public Usuario(Integer id) {
        this.id = id;
    }

    @Transient
    public Integer getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public BigDecimal getGastoFixo() {
        return gastoFixo;
    }

    public void setGastoFixo(BigDecimal gastoFixo) {
        this.gastoFixo = gastoFixo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("usuario", usuario)
                .append("senha", senha)
                .append("nome", nome)
                .append("numeroCartao", numeroCartao)
                .append("renda", renda)
                .append("tipoPerfil", tipoPerfil)
                .toString();
    }
}
