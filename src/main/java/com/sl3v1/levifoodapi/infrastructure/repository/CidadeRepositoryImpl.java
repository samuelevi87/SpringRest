package com.sl3v1.levifoodapi.infrastructure.repository;

import com.sl3v1.levifoodapi.domain.model.Cidade;
import com.sl3v1.levifoodapi.domain.repository.CidadeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listarTodas() {
        return manager.createQuery("from Cidade", Cidade.class).getResultList();
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Override
    public Cidade buscarPorId(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Cidade cidade = buscarPorId(id);
        if (Objects.isNull(cidade)){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cidade);
    }
}
