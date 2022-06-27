package com.sl3v1.levifoodapi.service;


import com.sl3v1.levifoodapi.modelo.Cliente;
import com.sl3v1.levifoodapi.notificacao.Notificador;
import org.springframework.stereotype.Component;


public class AtivacaoClienteService {

    private final Notificador notificador;

    public AtivacaoClienteService(Notificador notificador){
        this.notificador = notificador;
        System.out.println("AtivaçãoClienteService: " + notificador);
    }

    public void ativar(Cliente cliente){
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro está ativo!");
    }
}
