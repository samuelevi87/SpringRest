package com.sl3v1.levifoodapi.domain.services;

import com.sl3v1.levifoodapi.domain.exceptions.EntidadeEmUsoException;
import com.sl3v1.levifoodapi.domain.exceptions.EntidadeNaoEncontradaException;
import com.sl3v1.levifoodapi.domain.model.Cidade;
import com.sl3v1.levifoodapi.domain.model.Estado;
import com.sl3v1.levifoodapi.domain.repository.CidadeRepository;
import com.sl3v1.levifoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository repository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscarPorId(estadoId);
        if (Objects.isNull(estado)){
            throw new EntidadeNaoEncontradaException (String.format("Não existe estado com o id: %d", estadoId));
        }
        cidade.setEstado(estado);

        return repository.salvar(cidade);
    }

    public void remover(Long id) {
        try {
            repository.remover(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe cidade com o id: %d", id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cidade com id: %d não pode ser removida, pois está em uso!", id));
        }
    }
}
