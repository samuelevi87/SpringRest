package com.sl3v1.levifoodapi;

import com.sl3v1.levifoodapi.notificacao.NotificadorEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoConfig {
    @Bean
    public NotificadorEmail notificadorEmail() {
        NotificadorEmail notificador = new NotificadorEmail("smtp.levimail.com.br");
        notificador.setCaixaAlta(true);
        return notificador;
    }
}
