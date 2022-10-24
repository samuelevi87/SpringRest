package com.sl3v1.levifoodapi.domain.services;

import com.sl3v1.levifoodapi.domain.exceptions.EntidadeEmUsoException;
import com.sl3v1.levifoodapi.domain.exceptions.EntidadeNaoEncontradaException;
import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.CozinhaRepository;
import com.sl3v1.levifoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository repository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.buscarPorId(cozinhaId);

        if (Objects.isNull(cozinha)){
            throw new EntidadeNaoEncontradaException (String.format("Não existe cozinha com o id: %d", cozinhaId));
        }
        restaurante.setCozinha(cozinha);

        return repository.salvar(restaurante);
    }

    public void remover(Long id) {
        try {
            repository.remover(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um restaurante com o id: %d", id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Restaurante com id: %d não pode ser removido, pois está em uso!", id));
        }
    }

}
