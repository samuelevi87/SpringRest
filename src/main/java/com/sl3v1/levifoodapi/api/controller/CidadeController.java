package com.sl3v1.levifoodapi.api.controller;

import com.sl3v1.levifoodapi.domain.exceptions.EntidadeEmUsoException;
import com.sl3v1.levifoodapi.domain.exceptions.EntidadeNaoEncontradaException;
import com.sl3v1.levifoodapi.domain.model.Cidade;
import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.CidadeRepository;
import com.sl3v1.levifoodapi.domain.services.CidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @Autowired
    private CidadeService service;

    @GetMapping
    public List<Cidade> listar() {
        return repository.listarTodas();
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable("cidadeId") Long id) {
        Cidade cidadeProcurada = repository.buscarPorId(id);

        if (Objects.isNull(cidadeProcurada)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cidadeProcurada);
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Cidade cidadeParaAdicionar){
        try {
            cidadeParaAdicionar =  service.salvar(cidadeParaAdicionar);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(cidadeParaAdicionar);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade novaCidade) {
        Cidade cidadeAtual = repository.buscarPorId(cidadeId);
        if (Objects.isNull(cidadeAtual)) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(novaCidade, cidadeAtual, "id");
        service.salvar(cidadeAtual);
        return ResponseEntity.ok(cidadeAtual);
    }

    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<?> remover(@PathVariable Long cidadeId){
        try {
            service.remover(cidadeId);
            return ResponseEntity.noContent().build();
        }catch(EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
