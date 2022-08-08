package com.sl3v1.levifoodapi.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // Indica que a anotação será executada durante a execução do programa. Diz quanto tempo ela será mantida no código.
@Qualifier
public @interface TipoDoNotificador {
    NivelUrgencia value();
}
