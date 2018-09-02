package com.hackathon.julius.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(targetEntity = RespostaPreDefinida.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RespostaPreDefinida> respostasPredefinidas;

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

    public List<RespostaPreDefinida> getRespostasPredefinidas() {
        return respostasPredefinidas;
    }

    public void setRespostasPredefinidas(List<RespostaPreDefinida> respostasPredefinidas) {
        this.respostasPredefinidas = respostasPredefinidas;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("descricao", descricao)
                .append("respostasPredefinidas", respostasPredefinidas)
                .toString();
    }
}
