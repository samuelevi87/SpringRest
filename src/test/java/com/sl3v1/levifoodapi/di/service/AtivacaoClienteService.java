package com.sl3v1.levifoodapi.di.service;


import com.sl3v1.levifoodapi.di.modelo.Cliente;
import com.sl3v1.levifoodapi.di.notificacao.NotificadorEmail;

public class AtivacaoClienteService {

    private NotificadorEmail notificador;

    public void ativar(Cliente cliente){
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro está ativo!");
    }
}
