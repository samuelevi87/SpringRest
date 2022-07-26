package com.sl3v1.levifoodapi.listener;

import com.sl3v1.levifoodapi.di.service.ClienteAtivadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNotaFiscalService {

    @EventListener
    public void clienteAtivadoListeners(ClienteAtivadoEvent event) {
        System.out.println("Emitindo NF para o cliente " + event.getCliente().getNome());
    }
}
