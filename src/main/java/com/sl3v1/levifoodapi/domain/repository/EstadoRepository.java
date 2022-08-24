package com.sl3v1.levifoodapi.domain.repository;

import com.sl3v1.levifoodapi.domain.model.Estado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository {
    List<Estado> listarTodas();
    Estado buscarPorId(Long id);
    Estado salvar(Estado estado);
    void remover(Estado estado);
}
