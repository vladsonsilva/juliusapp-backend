package com.hackathon.julius.controller;

import com.hackathon.julius.dto.ObjetivoDTO;
import com.hackathon.julius.entity.Objetivo;
import com.hackathon.julius.entity.Usuario;
import com.hackathon.julius.repository.ObjetivoRepository;
import com.hackathon.julius.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ObjetivoController {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(path = "usuarios/{userId}/objetivos")
    public List<ObjetivoDTO> list(@PathVariable("userId") Integer userId) {
        List<ObjetivoDTO> objetivosDTO = new ArrayList<>();

        List<Objetivo> objetivos = objetivoRepository.findByUsuarioId(userId);
        for (Objetivo objetivo : objetivos) {
            objetivosDTO.add(ObjetivoDTO.build(objetivo));
        }

        return objetivosDTO;
    }

    @GetMapping(path = "usuarios/{userId}/objetivos/{id}")
    public ResponseEntity<Objetivo> find(@PathVariable("id") Integer id) {
        Optional<Objetivo> opt =  objetivoRepository.findById(id);

        return opt.isPresent() ? ResponseEntity.ok(opt.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "usuarios/{userId}/objetivos")
    public ResponseEntity<Objetivo> insert(@PathVariable("userId") Integer userId, @RequestBody @Valid ObjetivoDTO objetivoDTO) {
        Optional<Usuario> usuario = usuarioRepository.findById(userId);
        if (!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Objetivo objetivo = new Objetivo();
        objetivo.setDataEstipulada(objetivoDTO.getDataEstipulada());
        objetivo.setDescricao(objetivoDTO.getDescricao());
        objetivo.setValorEstipulado(objetivoDTO.getValorEstipulado());
        objetivo.setValorInvestido(objetivoDTO.getValorInvestido());
        objetivo.setUsuario(usuario.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(objetivoRepository.save(objetivo));
    }

    @PutMapping(path = "usuarios/{userId}/objetivos/{id}")
    public ResponseEntity<Objetivo> update(@PathVariable("id") Integer id, @RequestBody @Valid ObjetivoDTO objetivoDTO) {
        Optional<Objetivo> objetivoOptional = objetivoRepository.findById(id);

        if (objetivoOptional.isPresent()) {
            Objetivo objetivo = objetivoOptional.get();
            objetivo.setDataEstipulada(objetivoDTO.getDataEstipulada());
            objetivo.setDescricao(objetivoDTO.getDescricao());
            objetivo.setValorEstipulado(objetivoDTO.getValorEstipulado());
            objetivo.setValorInvestido(objetivoDTO.getValorInvestido());
            return ResponseEntity.ok(objetivoRepository.save(objetivo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "usuarios/{userId}/objetivos/{id}")
    public ResponseEntity<Objetivo> delete(@PathVariable("id") Integer id) {

        objetivoRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
