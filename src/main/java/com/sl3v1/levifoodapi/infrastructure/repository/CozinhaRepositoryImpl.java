package com.sl3v1.levifoodapi.infrastructure.repository;

import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> listarTodas() {
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Transactional
    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    public Cozinha buscarPorId(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public void remover(Cozinha cozinha) {
        cozinha = buscarPorId(cozinha.getId());
        manager.remove(cozinha);
    }
}
