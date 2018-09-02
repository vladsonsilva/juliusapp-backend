package com.hackathon.julius.controller;


import com.hackathon.julius.dto.RespostaPreDefinidaDTO;
import com.hackathon.julius.dto.UsuarioDTO;
import com.hackathon.julius.entity.ItemMesExtrato;
import com.hackathon.julius.entity.MesExtrato;
import com.hackathon.julius.entity.Usuario;
import com.hackathon.julius.entity.enums.TipoItemEnum;
import com.hackathon.julius.entity.enums.TipoPerfil;
import com.hackathon.julius.repository.ItemMesExtratoRepository;
import com.hackathon.julius.repository.MesExtratoRepository;
import com.hackathon.julius.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MesExtratoRepository mesExtratoRepository;

    @Autowired
    private ItemMesExtratoRepository itemMesExtratoRepository;

    @GetMapping(path = "/{userId}")
    public ResponseEntity<Usuario> find(@PathVariable("userId") Integer userId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(userId);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<Usuario> insert(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setRenda(usuarioDTO.getRenda());
        usuario.setNumeroCartao(usuarioDTO.getNumeroCartao());
        usuario.setGastoFixo(usuarioDTO.getGastoFixo());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());

        usuario.setTipoPerfil(criarTipoPerfil(usuarioDTO));
        criarExtratos(usuario);

        Usuario usuarioSalvo =  usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    /**
     * Método para criar tipo de perfil com base na pontuação das respostas.
     * @param usuarioDTO
     * @return
     */
    private TipoPerfil criarTipoPerfil(UsuarioDTO usuarioDTO) {
        List<RespostaPreDefinidaDTO> respostas = usuarioDTO.getRespostas();
        HashMap<TipoPerfil, BigDecimal> calculos = new HashMap<>();

        Stream.of(TipoPerfil.values()).forEach(tipo -> calculos.put(tipo, BigDecimal.ZERO));

        respostas.forEach(resp -> {
            resp.getPontos().forEach(ponto -> {
                BigDecimal newValue = calculos.get(ponto.getTipoPerfil());
                newValue = newValue.add(new BigDecimal(ponto.getTotal()));
                calculos.put(ponto.getTipoPerfil(), newValue);
            });
        });

        return calculos
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .findFirst()
                .get().getKey();
    }

    /**
     * Método para gerar extratos mensais aleatórios.
     * @param usuario
     * @return
     */
    private void criarExtratos(Usuario usuario) {
        LocalDate now = LocalDate.now();
        LocalDate before = now.minusMonths(13);

        while (before.isBefore(now)) {
            MesExtrato mesExtrato = new MesExtrato();
            mesExtrato.setMesAno(before);
            mesExtrato.setUsuario(usuario);

            List<ItemMesExtrato> items = new ArrayList<>();

            Stream.of(TipoItemEnum.values()).forEach(p -> {
                ItemMesExtrato item = new ItemMesExtrato();
                item.setTipo(p);
                item.setValor(BigDecimal.valueOf(Math.random() * 2000));
                items.add(item);
            });

            BigDecimal result = items.stream()
                    .map(ItemMesExtrato::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            mesExtrato.setGastoTotal(result);

            BigDecimal saldo = usuario.getRenda();
            saldo = saldo.subtract(result);

            mesExtrato.setSaldo(saldo);

            mesExtratoRepository.save(mesExtrato);

            for (ItemMesExtrato item : items) {
                item.setMesExtrato(mesExtrato);
                itemMesExtratoRepository.save(item);
            }

            before = before.plusMonths(1);
        }
    }

    @PostMapping(path = "/actions/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> login(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByUsuarioAndSenha(usuarioDTO.getUsuario(), usuarioDTO.getSenha()));

        return usuario.isPresent() ? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build();
    }


}
