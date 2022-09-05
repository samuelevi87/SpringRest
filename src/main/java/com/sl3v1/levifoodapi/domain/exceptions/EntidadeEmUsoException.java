package com.sl3v1.levifoodapi.domain.exceptions;

public class EntidadeEmUsoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
