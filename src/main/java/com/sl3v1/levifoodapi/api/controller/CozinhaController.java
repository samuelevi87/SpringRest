package com.sl3v1.levifoodapi.api.controller;

import com.sl3v1.levifoodapi.api.model.CozinhasXmlWrapper;
import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository repository;

    @GetMapping
    public List<Cozinha> listar() {
        return repository.listarTodas();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml() {
        return new CozinhasXmlWrapper(repository.listarTodas());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id){
//        return ResponseEntity.status(HttpStatus.OK).body(repository.buscarPorId(id));
//        return ResponseEntity.status(HttpStatus.OK).build();
//        return ResponseEntity.ok(repository.buscarPorId(id));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas");
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .headers(headers)
                .build();
    }
}
