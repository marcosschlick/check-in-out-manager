package com.controlador.presenca.repositories;

import com.controlador.presenca.entities.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {

    Presenca findTopByUsuarioIdOrderByIdDesc(Long usuarioId);

}