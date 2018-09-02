package com.hackathon.julius.controller;

import com.hackathon.julius.dto.PerguntaDTO;
import com.hackathon.julius.entity.Pergunta;
import com.hackathon.julius.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping(path = "/")
    public ResponseEntity<List<Pergunta>> getAll() {
        return ResponseEntity.ok(perguntaRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pergunta> getById(@PathVariable("id") Integer id) {
        Optional<Pergunta> opt =  perguntaRepository.findById(id);

        return opt.isPresent() ? ResponseEntity.ok(opt.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/")
    public ResponseEntity<Pergunta> insert(@RequestBody @Valid PerguntaDTO perguntaDTO) {
        Pergunta pergunta = new Pergunta();
        pergunta.setId(perguntaDTO.getId());
        pergunta.setDescricao(perguntaDTO.getPergunta());
        pergunta.setRespostasPredefinidas(perguntaDTO.getRespostasPredefinidas());

        return ResponseEntity.status(HttpStatus.CREATED).body(perguntaRepository.save(pergunta));
    }

//    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Pergunta> update (@PathVariable("id") Integer id, @RequestBody @Valid PerguntaDTO perguntaDTO) {
//        Optional<Pergunta> perguntaOld= perguntaRepository.findById(id);
//        Pergunta newPergunta = new Pergunta();
//
//        if (perguntaOld.isPresent()) {
//            newPergunta = perguntaOld.get();
//            newPergunta.setDescricao(perguntaDTO.getPergunta());
//            newPergunta.setRespostasPredefinidas(perguntaDTO.getRespostasPredefinidas().stream().map(resp -> new RespostaPreDefinida(resp)).collect(Collectors.toList()));
//            perguntaRepository.save(newPergunta);
//        }
//
//        return perguntaOld.isPresent() ? ResponseEntity.ok(newPergunta) : ResponseEntity.notFound().build();
//    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pergunta> delete (@PathVariable("id") Integer id) {
        Optional<Pergunta> perguntaOld = perguntaRepository.findById(id);
        perguntaRepository.delete(perguntaOld.get());

        return perguntaOld.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}


