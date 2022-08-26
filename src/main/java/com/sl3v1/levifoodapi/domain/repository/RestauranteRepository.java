package com.sl3v1.levifoodapi.domain.repository;

import com.sl3v1.levifoodapi.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> listarTodas();
    Restaurante buscarPorId(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Restaurante restaurante);
}
