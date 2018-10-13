package br.com.caelum.livraria.dao;

import model.Autor;
import model.Livro;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LivroDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Livro livro) {
        manager.persist(livro);
    }

    public List<Livro> findAll() {
        TypedQuery<Livro> query = manager.createQuery("select l from Livro l", Livro.class);
        return query.getResultList();
    }

}


