package com.hackathon.julius.dto;

import com.hackathon.julius.entity.Objetivo;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ObjetivoDTO {
    private Integer id;
    @NotEmpty(message = "O campo descrição é obrigatório")
    private String descricao;
    @NotNull(message = "O campo data estipulada é obrigatório")
    private LocalDate dataEstipulada;
    @NotNull(message = "O campo valor estipulado é obrigatório")
    private Double valorEstipulado;
    private Double valorInvestido;

    public static ObjetivoDTO build(Objetivo entidade) {
        ObjetivoDTO objetivoDTO = new ObjetivoDTO();
        objetivoDTO.setId(entidade.getId());
        objetivoDTO.setDescricao(entidade.getDescricao());
        objetivoDTO.setDataEstipulada(entidade.getDataEstipulada());
        objetivoDTO.setValorEstipulado(entidade.getValorEstipulado());
        objetivoDTO.setValorInvestido(entidade.getValorInvestido());

        return objetivoDTO;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }
}
