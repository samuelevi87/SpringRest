package com.sl3v1.levifoodapi.infrastructure.repository;

import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> listarTodas() {
        return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    public Restaurante buscarPorId(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante) {
        restaurante = buscarPorId(restaurante.getId());
        manager.remove(restaurante);
    }
}
