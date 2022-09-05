package com.sl3v1.levifoodapi.api.controller;

import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository repository;

    @GetMapping
    public List<Restaurante> listar() {
        return repository.listarTodas();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable("restauranteId") Long id) {
        Restaurante restauranteProcurada = repository.buscarPorId(id);

        if (Objects.isNull(restauranteProcurada)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restauranteProcurada);
    }
}
