package com.sl3v1.levifoodapi.di.service;


import com.sl3v1.levifoodapi.di.modelo.Cliente;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.NivelUrgencia;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.Notificador;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro está ativo!");
    }
}

