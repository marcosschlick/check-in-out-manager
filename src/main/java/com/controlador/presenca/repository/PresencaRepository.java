package com.controlador.presenca.repository;

import com.controlador.presenca.entity.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Integer> {

    Optional<Presenca> findTopByUsuarioIdOrderByIdDesc(int usuarioId);

}