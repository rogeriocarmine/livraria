package model.form;

import br.com.caelum.livraria.dao.AutorDao;
import model.Autor;
import model.Livro;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    private Integer id;
    @NotNull
    @NotEmpty
    private String titulo;
    @NotNull
    private BigDecimal preco;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEstimada;
    @NotNull
    @NotEmpty
    private String sumario;
    @NotNull
    private Integer autorId;

    public LivroForm() {
    }

    public Livro toLivro(AutorDao dao){
        Autor autor = dao.findOne(this.autorId);
        return new Livro(titulo,preco,dataEstimada,sumario,autor);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataEstimada() {
        return dataEstimada;
    }

    public void setDataEstimada(LocalDate dataEstimada) {
        this.dataEstimada = dataEstimada;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }
}
