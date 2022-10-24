package com.sl3v1.levifoodapi.api.controller;

import com.sl3v1.levifoodapi.domain.exceptions.EntidadeEmUsoException;
import com.sl3v1.levifoodapi.domain.exceptions.EntidadeNaoEncontradaException;
import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.RestauranteRepository;
import com.sl3v1.levifoodapi.domain.services.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository repository;

    @Autowired
    private RestauranteService service;

    @GetMapping
    public List<Restaurante> listar() {
        return repository.listarTodas();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable("restauranteId") Long id) {
        Restaurante restauranteProcurado = repository.buscarPorId(id);

        if (Objects.isNull(restauranteProcurado)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restauranteProcurado);
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restauranteParaAdicionar){
        try {
            restauranteParaAdicionar =  service.salvar(restauranteParaAdicionar);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(restauranteParaAdicionar);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{restauranteId}")
    public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante novoRestaurante) {
        Restaurante restauranteAtual = repository.buscarPorId(restauranteId);
        if (Objects.isNull(restauranteAtual)) {
            return ResponseEntity.notFound().build();
        }
        try {
            BeanUtils.copyProperties(novoRestaurante, restauranteAtual, "id");
            service.salvar(restauranteAtual);
            return ResponseEntity.ok(restauranteAtual);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{restauranteId}")
    public ResponseEntity<?> remover(@PathVariable Long restauranteId){
        try {
            service.remover(restauranteId);
            return ResponseEntity.noContent().build();
        }catch(EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
