package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.CozinhaRepository;
import com.sl3v1.levifoodapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaRestauranteMain {
    public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        RestauranteRepository repository = applicationContext.getBean(RestauranteRepository.class);
        Restaurante restaurante = repository.buscarPorId(5L);
        System.out.println(restaurante.getNome() + " - TxR$: " + restaurante.getTaxaFrete());
    }
}

