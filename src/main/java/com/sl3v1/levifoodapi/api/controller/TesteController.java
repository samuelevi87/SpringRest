package com.sl3v1.levifoodapi.api.controller;


import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository repository;

    @GetMapping("/cozinhas/por-nacionalidade")
    public List<Cozinha> cozinhasPorNacionalidade(@RequestParam("nacionalidade") String nacionalidade) {
        return  repository.consultarPorNacionalidade(nacionalidade);
    }
}
