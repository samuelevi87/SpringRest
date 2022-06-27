package com.sl3v1.levifoodapi.notificacao;

import com.sl3v1.levifoodapi.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
