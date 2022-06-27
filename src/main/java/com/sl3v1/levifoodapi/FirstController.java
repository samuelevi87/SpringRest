package com.sl3v1.levifoodapi;

import com.sl3v1.levifoodapi.di.modelo.Cliente;
import com.sl3v1.levifoodapi.di.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
    private final AtivacaoClienteService ativacaoClienteService;

    public FirstController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
        System.out.println("My First controller: " + ativacaoClienteService);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        Cliente samuel = new Cliente("Samuel Levi", "swaudby3d@cmu.edu", "27790078546");

        ativacaoClienteService.ativar(samuel);

        return "Hello";
    }

}
