package com.controlador.presenca.controller;

import com.controlador.presenca.entity.Usuario;
import com.controlador.presenca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Iterable<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable int id) {
        return usuarioRepository.findById(id);
    }
}

