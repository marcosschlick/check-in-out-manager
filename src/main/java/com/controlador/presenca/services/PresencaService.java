package com.controlador.presenca.services;

import com.controlador.presenca.entities.Presenca;
import com.controlador.presenca.entities.Usuario;
import com.controlador.presenca.repositories.PresencaRepository;
import com.controlador.presenca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class PresencaService {

    @Autowired
    private PresencaRepository presencaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String setEntrada(String documento) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByDocumento(documento);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
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
        Optional<Usuario> usuarioOptional = usuarioRepository.findByDocumento(documento);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Optional<Presenca> presencaOptional = presencaRepository.findTopByUsuarioIdOrderByIdDesc(usuario.getId());

            if (presencaOptional.isPresent()) {
                Presenca presenca = presencaOptional.get();

                if (presenca.getDataSaida() == null && presenca.getHorarioSaida() == null) {
                    presenca.setDataSaida(LocalDate.now());
                    presenca.setHorarioSaida(LocalTime.now());

                    presencaRepository.save(presenca);

                    return "Saída registrada com sucesso para o usuário: " + usuario.getNome();
                } else {
                    return "O usuário já tem um registro de saída.";
                }
            } else {
                return "Não há registro de entrada para o usuário: " + usuario.getNome();
            }
        } else {
            return "Usuário com o documento " + documento + " não cadastrado.";
        }
    }
}
