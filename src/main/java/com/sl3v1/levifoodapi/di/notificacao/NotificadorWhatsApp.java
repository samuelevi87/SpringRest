package com.sl3v1.levifoodapi.di.notificacao;


import com.sl3v1.levifoodapi.di.modelo.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@TipoDoNotificador(NivelUrgencia.ALTO)
@Component
public class NotificadorWhatsApp implements Notificador {

    public NotificadorWhatsApp(){
        System.out.println("NotificadorWhatsApp REAL");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por WhatsApp (As Soon As Possible) através do telefone %s: %s\n", cliente.getNome(), cliente.getTelefone(), mensagem);
    }

}
