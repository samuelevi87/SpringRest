package com.sl3v1.levifoodapi.listener;

import com.sl3v1.levifoodapi.di.notificacao.notificacao.NivelUrgencia;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.Notificador;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.TipoDoNotificador;
import com.sl3v1.levifoodapi.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListeners(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Cliente ativado com sucesso!");
    }
}
