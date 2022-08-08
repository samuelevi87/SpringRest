package com.sl3v1.levifoodapi.di.notificacao;


import com.sl3v1.levifoodapi.di.modelo.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@TipoDoNotificador(NivelUrgencia.MEDIO)
@Component
public class NotificadorSMS implements Notificador {

    public NotificadorSMS(){
        System.out.println("NotificadorSMS REAL");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n", cliente.getNome(), cliente.getTelefone(), mensagem);
    }

}
