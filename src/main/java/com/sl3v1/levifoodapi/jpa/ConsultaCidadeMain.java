package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.Cidade;
import com.sl3v1.levifoodapi.domain.repository.CidadeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCidadeMain {
    public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        CidadeRepository repository = applicationContext.getBean(CidadeRepository.class);
        List<Cidade> cidades = repository.listarTodas();
        cidades.forEach(city -> System.out.println(city.getId() + " - " + city.getNome() + " - " + city.getEstado().getSigla()));
    }
}

