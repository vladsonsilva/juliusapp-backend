package com.hackathon.julius.repository;

import com.hackathon.julius.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    List<Usuario> findAll();
    Usuario findByUsuarioAndSenha(String usuario, String password);
}
