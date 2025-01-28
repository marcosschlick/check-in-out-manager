package com.controlador.presenca.services;

import com.controlador.presenca.dto.PresencaDTO;
import com.controlador.presenca.entities.Presenca;
import com.controlador.presenca.entities.Usuario;
import com.controlador.presenca.repositories.PresencaRepository;
import com.controlador.presenca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PresencaService {

    @Autowired
    private PresencaRepository presencaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<PresencaDTO> findAll() {
        List<Presenca> result = presencaRepository.findAll();
        List<PresencaDTO> dto = result.stream().map(x -> new PresencaDTO(x)).toList();
        return dto;
    }

    public String setEntrada(String documento) {
        Usuario usuario = usuarioRepository.findByDocumento(documento); // Retorna null se não encontrar

        if (usuario != null) {
            Presenca presenca = new Presenca();
            presenca.setUsuario(usuario);
            presenca.setDataEntrada(LocalDate.now());
            presenca.setHorarioEntrada(LocalTime.now());

            presencaRepository.save(presenca);

            return "Presença registrada com sucesso para o usuário: " + usuario.getNome();
        } else {
            return "Usuário com o documento " + documento + " não cadastrado.";
        }
    }

    public String setSaida(String documento) {
        Usuario usuario = usuarioRepository.findByDocumento(documento); // Retorna null se não encontrar

        if (usuario == null) {
            return "Usuário com o documento " + documento + " não cadastrado.";
        }

        Presenca presenca = presencaRepository.findTopByUsuarioIdOrderByIdDesc(usuario.getId()); // Retorna null se não encontrar

        if (presenca == null) {
            return "Não há registro de entrada para o usuário: " + usuario.getNome();
        }

        if (presenca.getDataSaida() != null || presenca.getHorarioSaida() != null) {
            return "O usuário já tem um registro de saída.";
        }

        presenca.setDataSaida(LocalDate.now());
        presenca.setHorarioSaida(LocalTime.now());
        presencaRepository.save(presenca);

        return "Saída registrada com sucesso para o usuário: " + usuario.getNome();
    }
}
