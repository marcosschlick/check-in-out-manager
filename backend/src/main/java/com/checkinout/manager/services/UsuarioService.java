package com.checkinout.manager.services;

import com.checkinout.manager.dtos.UsuarioDTO;
import com.checkinout.manager.entities.Usuario;
import com.checkinout.manager.repositories.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        List<Usuario> result = usuarioRepository.findAll();
        List<UsuarioDTO> dto = result.stream().map(x -> new UsuarioDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id) {
        Usuario result = usuarioRepository.findById(id).get();
        return new UsuarioDTO(result);
    }
}
