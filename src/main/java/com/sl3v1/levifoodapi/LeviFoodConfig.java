package com.sl3v1.levifoodapi;

import com.sl3v1.levifoodapi.notificacao.NotificadorEmail;
import com.sl3v1.levifoodapi.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class LeviFoodConfig {

    @Bean
    public NotificadorEmail notificadorEmail() {
        NotificadorEmail notificador = new NotificadorEmail("smtp.levimail.com.br");
        notificador.setCaixaAlta(true);
        return notificador;
    }

    @Bean
    public AtivacaoClienteService ativacaoClienteService() {
        return new AtivacaoClienteService(notificadorEmail());
    }
}
