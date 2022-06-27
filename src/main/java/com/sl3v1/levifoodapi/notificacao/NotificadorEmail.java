package com.sl3v1.levifoodapi.notificacao;


import com.sl3v1.levifoodapi.modelo.Cliente;
import org.springframework.stereotype.Component;


public class NotificadorEmail implements Notificador {

    private boolean caixaAlta;
    private final String hostServidorSmtp;

    public NotificadorEmail(String hostServidorSmtp) {
        this.hostServidorSmtp = hostServidorSmtp;
        System.out.println("NotificadorEmail");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){
        if (this.caixaAlta){
            mensagem = mensagem.toUpperCase();
        }
        System.out.printf("Notificando %s através do e-mail %s usando SMTP  %s: %s\n", cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, mensagem);
    }

    public void setCaixaAlta(boolean caixaAlta) {
        this.caixaAlta = caixaAlta;
    }
}
