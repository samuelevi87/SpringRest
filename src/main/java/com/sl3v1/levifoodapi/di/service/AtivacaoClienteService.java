package com.sl3v1.levifoodapi.di.service;


import com.sl3v1.levifoodapi.di.modelo.Cliente;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.NivelUrgencia;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.Notificador;
import com.sl3v1.levifoodapi.di.notificacao.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @PostConstruct //@PostConstruct indica para o Spring que um método é executado após a construção do objeto que será executado. Essa anotação faz poarte da especificação da JSR-250, mas o Spring a utiliza.
    public void init(){
        System.out.println("INIT " + notificador);
    }

    @PreDestroy //@PreDestroy indica para o Spring que um método é executado antes da destruição do objeto que será destruído.
    public void destroy(){
        System.out.println("DESTROY");
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro está ativo!");
    }
}

