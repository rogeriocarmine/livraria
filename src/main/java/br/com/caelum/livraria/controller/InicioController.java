package br.com.caelum.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {

    @GetMapping("/inicio")
    public ModelAndView carregar(){

        System.out.println("No controller Inicio!");

        ModelAndView mav=new ModelAndView("inicio");

        String titulo="Pagina de Teste com Spring MVC";

        mav.addObject("titulo",titulo );

        return mav;
    }

}
