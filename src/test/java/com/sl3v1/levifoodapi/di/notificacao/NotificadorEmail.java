package com.sl3v1.levifoodapi.di.notificacao;


import com.sl3v1.levifoodapi.di.modelo.Cliente;

public class NotificadorEmail {
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
