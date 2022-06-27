package com.sl3v1.levifoodapi.di.service;


import com.sl3v1.levifoodapi.di.modelo.Cliente;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private Notificador notificador;

    @Autowired
    public AtivacaoClienteService(Notificador notificador){
        this.notificador = notificador;
    }

    public AtivacaoClienteService(String qualified) {
        this.notificador = notificador;
    }

    public void ativar(Cliente cliente){
        cliente.ativar();
        this.notificador.notificar(cliente, "Seu cadastro está ativo!");
    }
}
