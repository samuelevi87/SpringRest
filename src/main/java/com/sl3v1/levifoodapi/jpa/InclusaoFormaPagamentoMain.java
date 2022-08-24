package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.FormaPagamento;
import com.sl3v1.levifoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class InclusaoFormaPagamentoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository repository = applicationContext.getBean(FormaPagamentoRepository.class);

        FormaPagamento fpag1 = new FormaPagamento();
        fpag1.setDescricao("Dinheiro");
        FormaPagamento fpag2 = new FormaPagamento();
        fpag2.setDescricao("Cartão de Crédito");
        FormaPagamento fpag3 = new FormaPagamento();
        fpag3.setDescricao("Cartão de Débito");

        FormaPagamento fpg1 = repository.salvar(fpag1);
        FormaPagamento fpg2 = repository.salvar(fpag2);
        FormaPagamento fpg3 = repository.salvar(fpag3);
        System.out.printf("%d - %s\n", fpg1.getId(), fpg1.getDescricao());
        System.out.printf("%d - %s\n", fpg2.getId(), fpg2.getDescricao());
        System.out.printf("%d - %s\n", fpg3.getId(), fpg3.getDescricao());
    }
}

