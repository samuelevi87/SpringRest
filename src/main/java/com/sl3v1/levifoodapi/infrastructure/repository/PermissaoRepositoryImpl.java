package com.sl3v1.levifoodapi.infrastructure.repository;

import com.sl3v1.levifoodapi.domain.model.Permissao;
import com.sl3v1.levifoodapi.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> listarTodas() {
        return manager.createQuery("from Permissao", Permissao.class).getResultList();
    }

    @Transactional
    @Override
    public Permissao salvar(Permissao permissao) {
        return manager.merge(permissao);
    }

    @Override
    public Permissao buscarPorId(Long id) {
        return manager.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao) {
        permissao = buscarPorId(permissao.getId());
        manager.remove(permissao);
    }
}
