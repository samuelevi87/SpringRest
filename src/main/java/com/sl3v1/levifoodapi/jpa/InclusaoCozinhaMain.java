package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNacionalidade("Mediterrânea");
        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNacionalidade("Grega");

        Cozinha c1 = cadastroCozinha.adicionar(cozinha1);
        Cozinha c2 = cadastroCozinha.adicionar(cozinha2);
        System.out.printf("%d - %s\n", c1.getId(), c1.getNacionalidade());
        System.out.printf("%d - %s\n", c2.getId(), c2.getNacionalidade());
    }
}

