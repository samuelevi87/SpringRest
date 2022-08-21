package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.Cozinha;
import com.sl3v1.levifoodapi.domain.model.Restaurante;
import com.sl3v1.levifoodapi.domain.repository.CozinhaRepository;
import com.sl3v1.levifoodapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {
    public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        RestauranteRepository repository = applicationContext.getBean(RestauranteRepository.class);
        List<Restaurante> restaurantes = repository.listarTodas();
        restaurantes.forEach(restaurante -> System.out.println(restaurante.getId() + " - " + restaurante.getNome() + " - " + restaurante.getTaxaFrete() + " - " + restaurante.getCozinha().getNacionalidade()));
    }
}

