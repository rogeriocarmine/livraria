package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Livro {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    @Column(unique=true)
    private String titulo;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private LocalDate dataEstimada;
    @NotNull
    private String sumario;
    @NotNull
    @ManyToOne
    private Autor autor;

    public Livro() {
    }

    public Livro(String titulo, BigDecimal preco, LocalDate dataEstimada, String sumario, Autor autor) {
        this.titulo = titulo;
        this.preco = preco;
        this.dataEstimada = dataEstimada;
        this.sumario = sumario;
        this.autor = autor;
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

    public String getDataEstimadaString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataTexto=this.dataEstimada.format(formatador);
        return dataTexto;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}


