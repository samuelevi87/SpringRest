package com.sl3v1.levifoodapi.jpa;

import com.sl3v1.levifoodapi.LevifoodApiApplication;
import com.sl3v1.levifoodapi.domain.model.Permissao;
import com.sl3v1.levifoodapi.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoPermissaoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(LevifoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissaoRepository repository = applicationContext.getBean(PermissaoRepository.class);

        Permissao permissao1 = new Permissao();
        permissao1.setNome("ROLE_FIND_ALL");
        permissao1.setDescricao("Consultar Todos os Registros");
        Permissao permissao2 = new Permissao();
        permissao2.setNome("ROLE_INCLUDE_ALTER");
        permissao2.setDescricao("Incluir/Alterar um Registro");
        Permissao permissao3 = new Permissao();
        permissao3.setNome("ROLE_REMOVE");
        permissao3.setDescricao("Remover um Registro");
        

        Permissao permit1 = repository.salvar(permissao1);
        Permissao permit2 = repository.salvar(permissao2);
        Permissao permit3 = repository.salvar(permissao3);
        System.out.printf("%d - %s - %s\n", permit1.getId(), permit1.getNome(), permit1.getDescricao());
        System.out.printf("%d - %s - %s\n", permit2.getId(), permit2.getNome(), permit2.getDescricao());
        System.out.printf("%d - %s - %s\n", permit3.getId(), permit3.getNome(), permit3.getDescricao());
    }
}

