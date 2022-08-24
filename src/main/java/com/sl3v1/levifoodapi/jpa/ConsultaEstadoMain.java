package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.Estado;
import com.sl3v1.levifoodapi.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaEstadoMain {
    public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        EstadoRepository repository = applicationContext.getBean(EstadoRepository.class);
        List<Estado> estados = repository.listarTodas();
        estados.forEach(ufs -> System.out.println(ufs.getId() + " - " + ufs.getSigla() + "-" +  ufs.getNome()));
    }
}

