package com.sl3v1.levifoodapi.infrastructure.repository;

import com.sl3v1.levifoodapi.domain.model.FormaPagamento;
import com.sl3v1.levifoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listarTodas() {
        return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }

    @Transactional
    @Override
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return manager.merge(formaPagamento);
    }

    @Override
    public FormaPagamento buscarPorId(Long id) {
        return manager.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento formaPagamento) {
        formaPagamento = buscarPorId(formaPagamento.getId());
        manager.remove(formaPagamento);
    }
}
