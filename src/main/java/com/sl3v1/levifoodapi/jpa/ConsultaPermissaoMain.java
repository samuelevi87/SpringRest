package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.Permissao;
import com.sl3v1.levifoodapi.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaPermissaoMain {
    public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        PermissaoRepository repository = applicationContext.getBean(PermissaoRepository.class);
        List<Permissao> permissoes = repository.listarTodas();
        permissoes.forEach(permits -> System.out.println(permits.getId()+ " - " + permits.getNome() + " - " + permits.getDescricao()));
    }
}

