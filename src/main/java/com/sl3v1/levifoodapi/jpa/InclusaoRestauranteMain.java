package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository repository = applicationContext.getBean(RestauranteRepository.class);

        Restaurante rest1 = new Restaurante();
        rest1.setNome("Sal");
        rest1.setTaxaFrete(BigDecimal.TEN);
        Restaurante rest2 = new Restaurante();
        rest2.setNome("El Porco");
        rest2.setTaxaFrete(BigDecimal.valueOf(17.5));

        Restaurante r1 = repository.salvar(rest1);
        Restaurante r2 = repository.salvar(rest2);
        System.out.printf("%d - %s\n", r1.getId(), r1.getNome());
        System.out.printf("%d - %s\n", r2.getId(), r2.getNome());
    }
}

