package com.sl3v1.levifoodapi.domain.repository;

import com.sl3v1.levifoodapi.domain.model.Cidade;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CidadeRepository {
    List<Cidade> listarTodas();
    Cidade buscarPorId(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Long id);
}
