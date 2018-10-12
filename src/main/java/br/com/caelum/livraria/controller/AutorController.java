package br.com.caelum.livraria.controller;

import br.com.caelum.livraria.dao.AutorDao;
import model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AutorController {

    @Autowired
    private AutorDao dao;

    @GetMapping("/autor/cadastro")
    public ModelAndView form(){

        ModelAndView mav=new ModelAndView("autor/cadastro");

        return mav;
    }

    @PostMapping("/autor/salvar")
    @Transactional
    public ModelAndView salvar(Autor autor){

        ModelAndView mav=new ModelAndView("redirect:/autor/listar");

        dao.save(autor);

        return mav;
    }

    @GetMapping("/autor/listar")
    public ModelAndView listar(){

        System.out.println("No auto controller - antes");

        ModelAndView mav=new ModelAndView("autor/listagem");

        List<Autor> lista = dao.findAll();

        System.out.println("No auto controller - depois");

        for(Autor obj:lista){
            System.out.println("Autor:"+obj.getNome());
        }

        mav.addObject("autores",lista);

        return mav;
    }



}
