package com.sl3v1.levifoodapi.domain.repository;

import com.sl3v1.levifoodapi.domain.model.FormaPagamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository {
    List<FormaPagamento> listarTodas();
    FormaPagamento buscarPorId(Long id);
    FormaPagamento salvar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);
}
