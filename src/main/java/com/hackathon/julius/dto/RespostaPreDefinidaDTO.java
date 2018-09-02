package com.hackathon.julius.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class RespostaPreDefinidaDTO {

    private List<PontoRespostaDTO> pontos;

    private String descricao;

    public List<PontoRespostaDTO> getPontos() {
        return pontos;
    }

    public void setPontos(List<PontoRespostaDTO> pontos) {
        this.pontos = pontos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pontos", pontos)
                .append("descricao", descricao)
                .toString();
    }
}
