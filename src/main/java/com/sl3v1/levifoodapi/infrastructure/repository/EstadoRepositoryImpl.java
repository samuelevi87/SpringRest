package com.sl3v1.levifoodapi.infrastructure.repository;

import com.sl3v1.levifoodapi.domain.model.Estado;
import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.EstadoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listarTodas() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }

    @Override
    public Estado buscarPorId(Long id) {
        return manager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Estado estado = buscarPorId(id);
        if (Objects.isNull(estado)){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(estado);
    }
}
