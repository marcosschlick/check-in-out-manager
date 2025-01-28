package com.controlador.presenca.controllers;

import com.controlador.presenca.dto.UsuarioDTO;
import com.controlador.presenca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> getUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping(path = "/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
}

