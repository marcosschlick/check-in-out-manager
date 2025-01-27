package com.controlador.presenca.controllers;

import com.controlador.presenca.entities.Presenca;
import com.controlador.presenca.repositories.PresencaRepository;
import com.controlador.presenca.services.PresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presenca")
public class PresencaController {

    @Autowired
    private PresencaRepository presencaRepository;

    @Autowired
    private PresencaService presencaService;

    @GetMapping
    public Iterable<Presenca> getPresencas() {
        return presencaRepository.findAll();
    }

    @PostMapping(path = "/entrada/{documento}")
    public String registrarEntrada(@PathVariable String documento) {
        return presencaService.setEntrada(documento);
    }

    @PutMapping(path = "/saida/{documento}")
    public String registrarSaida(@PathVariable String documento) {
        return presencaService.setSaida(documento);
    }
}
