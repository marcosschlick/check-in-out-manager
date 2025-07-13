package com.checkinout.manager.dto;

import com.checkinout.manager.entities.Presenca;
import com.checkinout.manager.entities.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;

public class PresencaDTO {

    private Long id;
    private Usuario usuario;
    private LocalDate dataEntrada;
    private LocalTime horarioEntrada;
    private LocalDate dataSaida;
    private LocalTime horarioSaida;

    public PresencaDTO() {
    }

    public PresencaDTO(Presenca entity) {
        this.id = entity.getId();
        this.usuario = entity.getUsuario();
        this.dataEntrada = entity.getDataEntrada();
        this.horarioEntrada = entity.getHorarioEntrada();
        this.dataSaida = entity.getDataSaida();
        this.horarioSaida = entity.getHorarioSaida();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}
