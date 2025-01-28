package com.controlador.presenca.controllers;

import com.controlador.presenca.dto.PresencaDTO;
import com.controlador.presenca.services.PresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presenca")
public class PresencaController {

    @Autowired
    private PresencaService presencaService;

    @GetMapping
    public List<PresencaDTO> getPresencas() {
        return presencaService.findAll();
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
