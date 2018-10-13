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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        Livro livro = livroForm.toLivro(autorDao);

        livroDao.save(livro);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Imprimindo o e-mail
        System.out.println("------------------------------------------------------------"+
                            "Enviando email sobre o Livro\n"+
                            "Titulo:"+livro.getTitulo()+"\n"+
                            "Autor:"+livro.getAutor().getNome()+"\n"+
                            "Data Estimada:"+formatador.format(livro.getDataEstimada())
                           +"-----------------------------------------------------------" );


        return mav;
    }

    @GetMapping("/livro/listar")
    public ModelAndView listar() {

        ModelAndView mav = new ModelAndView("livro/listagem");

        List<Livro> lista = livroDao.findAll();

        mav.addObject("livros", lista);

        return mav;
    }

    @GetMapping("/livro/{id}/detalhe")
    public ModelAndView detalhe(@PathVariable("id") Integer id) {

        ModelAndView mav = new ModelAndView("livro/detalhes");

        Livro livro = livroDao.findOne(id);

        mav.addObject("livro", livro);

        return mav;
    }

    @GetMapping("/home")
    public ModelAndView listarRecentes() {

        ModelAndView mav = new ModelAndView("home");

        //Todos os Livros
        List<Livro> livros = livroDao.findAll();

        //Considerando 30 dias como data de corte para lançamentos
        List<Livro> livrosRecentes = livroDao.findRecentes(LocalDate.now().minusDays(60));

        mav.addObject("livros", livros);
        mav.addObject("livrosRecentes", livrosRecentes);

        return mav;
    }


}


