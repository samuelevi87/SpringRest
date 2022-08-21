package com.sl3v1.levifoodapi.domain.repository;

import com.sl3v1.levifoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository {
    List<Cozinha> listarTodas();
    Cozinha buscarPorId(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Cozinha cozinha);
}
