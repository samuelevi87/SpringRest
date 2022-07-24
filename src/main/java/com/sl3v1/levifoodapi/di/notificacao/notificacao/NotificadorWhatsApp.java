package com.sl3v1.levifoodapi.di.notificacao.notificacao;


import com.sl3v1.levifoodapi.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@TipoDoNotificador(NivelUrgencia.ALTO)
@Component
public class NotificadorWhatsApp implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por WhatsApp (As Soon As Possible) através do telefone %s: %s\n", cliente.getNome(), cliente.getTelefone(), mensagem);
    }

}
