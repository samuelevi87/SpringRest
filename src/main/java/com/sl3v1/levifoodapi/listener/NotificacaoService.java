package com.sl3v1.levifoodapi.listener;

import com.sl3v1.levifoodapi.di.notificacao.NivelUrgencia;
import com.sl3v1.levifoodapi.di.notificacao.Notificador;
import com.sl3v1.levifoodapi.di.notificacao.TipoDoNotificador;
import com.sl3v1.levifoodapi.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.ALTO)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Cliente ativado com sucesso!");
    }
}
