package com.sl3v1.levifoodapi.domain.repository;

import com.sl3v1.levifoodapi.domain.model.Permissao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository {
    List<Permissao> listarTodas();
    Permissao buscarPorId(Long id);
    Permissao salvar(Permissao permissao);
    void remover(Permissao permissao);
}
