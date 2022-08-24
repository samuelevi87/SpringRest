package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.FormaPagamento;
import com.sl3v1.levifoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaFormaPagamentoMain {
    public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        FormaPagamentoRepository repository = applicationContext.getBean(FormaPagamentoRepository.class);
        List<FormaPagamento> formasPagamentos = repository.listarTodas();
        formasPagamentos.forEach(formas -> System.out.println(formas.getId() + " - " + formas.getDescricao()));
    }
}

