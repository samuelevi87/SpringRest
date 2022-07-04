package com.sl3v1.levifoodapi.di.service;


import com.sl3v1.levifoodapi.di.modelo.Cliente;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AtivacaoClienteService {

    @Autowired(required = false)
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        if ((Objects.nonNull(notificador))) {
            this.notificador.notificar(cliente, "Seu cadastro está ativo!");
        } else {
            System.out.println("Não existe notificador, mas o cliente está ativo!");
        }
    }
}

