package com.sl3v1.levifoodapi.api.controller;

import com.sl3v1.levifoodapi.domain.exceptions.EntidadeEmUsoException;
import com.sl3v1.levifoodapi.domain.exceptions.EntidadeNaoEncontradaException;
import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.repository.CozinhaRepository;
import com.sl3v1.levifoodapi.domain.services.CozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository repository;

    @Autowired
    private CozinhaService service;

    @GetMapping
    public List<Cozinha> listar() {
        return repository.listarTodas();
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
        Cozinha cozinhaProcurada = repository.buscarPorId(id);

        if (Objects.isNull(cozinhaProcurada)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cozinhaProcurada);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha novaCozinha) {
        Cozinha cozinhaAtual = repository.buscarPorId(cozinhaId);
        if (Objects.isNull(cozinhaAtual)) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(novaCozinha, cozinhaAtual, "id");
        service.salvar(cozinhaAtual);
        return ResponseEntity.ok(cozinhaAtual);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinhaParaAdicionar) {
        return service.salvar(cozinhaParaAdicionar);
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
        try {
            service.remover(cozinhaId);
            return ResponseEntity.noContent().build();
        }catch(EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
