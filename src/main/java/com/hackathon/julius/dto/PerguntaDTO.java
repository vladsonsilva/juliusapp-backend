package com.hackathon.julius.dto;

import com.hackathon.julius.entity.RespostaPreDefinida;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class PerguntaDTO {
    private Integer id;

    @NotEmpty(message = "O campo pergunta é obrigatório")
    private String pergunta;
    private List<RespostaPreDefinida> respostasPredefinidas;

    public PerguntaDTO(){}
    public PerguntaDTO(Integer id,String pergunta){
        this.pergunta = pergunta;
        this.id = id;
        this.respostasPredefinidas = new ArrayList<RespostaPreDefinida>();
    }
    public PerguntaDTO(Integer id,String pergunta, List<RespostaPreDefinida> respostasPredefinidas){
        this.pergunta = pergunta;
        this.id = id;
        this.respostasPredefinidas = respostasPredefinidas;
    }

    public List<RespostaPreDefinida> getRespostasPredefinidas() {
        return respostasPredefinidas;
    }

    public void setRespostasPredefinidas(List<RespostaPreDefinida> respostasPredefinidas) {
        this.respostasPredefinidas = respostasPredefinidas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}
