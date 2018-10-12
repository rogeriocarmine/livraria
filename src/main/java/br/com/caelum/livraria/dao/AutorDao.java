package br.com.caelum.livraria.dao;

import model.Autor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Autor autor) {
        manager.persist(autor);
    }

    public List<Autor> findAll() {
        TypedQuery<Autor> query=manager.createQuery("select a from Autor a", Autor.class);
        return query.getResultList();
    }

}
