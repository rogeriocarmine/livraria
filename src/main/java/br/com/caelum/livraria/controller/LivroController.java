package br.com.caelum.livraria.controller;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.LivroDao;
import model.Autor;
import model.Livro;
import model.form.LivroForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LivroController {


    @Autowired
    private LivroDao livroDao;

    @Autowired
    private AutorDao autorDao;

    @GetMapping("/livro/cadastrar")
    public ModelAndView form(LivroForm livroForm) {

        ModelAndView mav = new ModelAndView("livro/cadastro");

        mav.addObject("autores", autorDao.findAll());
        mav.addObject("form", livroForm);

        return mav;
    }

    @PostMapping("/livro/salvar")
    @Transactional
    public ModelAndView salvar(@Valid LivroForm livroForm, BindingResult result) {

        ModelAndView mav = new ModelAndView("redirect:/livro/listar");

        if (result.hasErrors()) {
            return form(livroForm);
        }

        livroDao.save(livroForm.toLivro(autorDao));

        return mav;
    }

    @GetMapping("/livro/listar")
    public ModelAndView listar() {

        ModelAndView mav = new ModelAndView("livro/listagem");

        List<Livro> lista = livroDao.findAll();

        mav.addObject("livros", lista);

        return mav;
    }


}


