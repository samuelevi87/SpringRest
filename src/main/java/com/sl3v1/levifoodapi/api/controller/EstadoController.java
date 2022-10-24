package com.sl3v1.levifoodapi.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl3v1.levifoodapi.domain.exceptions.EntidadeEmUsoException;
import com.sl3v1.levifoodapi.domain.exceptions.EntidadeNaoEncontradaException;
import com.sl3v1.levifoodapi.domain.model.Estado;
import com.sl3v1.levifoodapi.domain.repository.EstadoRepository;
import com.sl3v1.levifoodapi.domain.services.EstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @Autowired
    private EstadoService service;

    @GetMapping
    public List<Estado> listar() {
        return repository.listarTodas();
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscar(@PathVariable("estadoId") Long id) {
        Estado estadoProcurada = repository.buscarPorId(id);

        if (Objects.isNull(estadoProcurada)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadoProcurada);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estadoParaAdicionar) {
        return service.salvar(estadoParaAdicionar);
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, @RequestBody Estado novoEstado) {
        Estado estadoAtual = repository.buscarPorId(estadoId);
        if (Objects.isNull(estadoAtual)) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(novoEstado, estadoAtual, "id");
        service.salvar(estadoAtual);
        return ResponseEntity.ok(estadoAtual);
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<?> remover(@PathVariable Long estadoId){
        try {
            service.remover(estadoId);
            return ResponseEntity.noContent().build();
        }catch(EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
