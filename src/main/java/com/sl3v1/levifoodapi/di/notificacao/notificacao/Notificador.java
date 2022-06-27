package com.sl3v1.levifoodapi.di.notificacao.notificacao;

import com.sl3v1.levifoodapi.di.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
