package com.hackathon.julius.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class UsuarioDTO {

    private String nome;
    private String senha;
    private String usuario;
    private String numeroCartao;
    private BigDecimal renda;
    private BigDecimal gastoFixo;
    private LocalDate dataNascimento;
    private List<RespostaPreDefinidaDTO> respostas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public List<RespostaPreDefinidaDTO> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaPreDefinidaDTO> respostas) {
        this.respostas = respostas;
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
                .append("nome", nome)
                .append("senha", senha)
                .append("usuario", usuario)
                .append("numeroCartao", numeroCartao)
                .append("renda", renda)
                .append("respostas", respostas)
                .toString();
    }
}
