package com.freshonion.repositories;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.freshonion.entities.Filme;
import com.freshonion.entities.Livro;
import com.freshonion.entities.Obra;
import com.freshonion.entities.Serie;
import com.freshonion.entities.TopFreshFilme;
import com.freshonion.entities.TopFreshLivro;
import com.freshonion.entities.TopFreshSerie;

@Stateless
public class ObraRepository {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("FreshOnionUnit");
    EntityManager em = emf.createEntityManager();
    
    public void atualizaObra(Obra obra) {
        Obra obraBD = buscaObraId(obra.getId());
        Float somaDasNotas = Float.parseFloat("0");
        for(int i = 0; i < obraBD.getCriticas().size(); i++) {
            somaDasNotas += obraBD.getCriticas().get(i).getNota();
        }
                
        obra.setNotaAvaliacao(somaDasNotas/(obraBD.getCriticas().size())); 
        
        em.getTransaction().begin(); 
        em.merge(obra);
        em.getTransaction().commit();
    }
    
    public void adicionaFilme(Filme filme) {
        em.getTransaction().begin(); 
        em.persist(filme);
        em.getTransaction().commit();
        TopFreshFilme topFilme = new TopFreshFilme(filme);
        em.getTransaction().begin(); 
        em.persist(topFilme);
        em.getTransaction().commit();
    }
    
    public void adicionaSerie(Serie serie) {
        em.getTransaction().begin(); 
        em.persist(serie);
        em.getTransaction().commit();
        TopFreshSerie topSerie = new TopFreshSerie(serie);
        em.getTransaction().begin(); 
        em.persist(topSerie);
        em.getTransaction().commit();
    }
    
    public void adicionaLivro(Livro livro) {
        em.getTransaction().begin(); 
        em.persist(livro);
        em.getTransaction().commit();
        TopFreshLivro topLivro = new TopFreshLivro();
        em.getTransaction().begin(); 
        em.persist(topLivro);
        em.getTransaction().commit();
    }
    
    public Obra buscaObraId(int id) {
        return em.find(Obra.class, id);
    }
    
    public Filme buscaFilmeId(int id) {
    	return em.find(Filme.class, id);
    }
    
    public Serie buscaSerieId(int id) {
        return em.find(Serie.class, id);
    }
    
    public Livro buscaLivroId(int id) {
        return em.find(Livro.class, id);
    }

    public List<Filme> buscaTopFreshFilme(int max){
		return em.createQuery("SELECT filme FROM TopFreshFilme f ORDER BY f.filme.notaAvaliacao DESC", Filme.class).setMaxResults(max).getResultList();	
	}
    
    public List<Serie> buscaTopFreshSerie(int max){
        return em.createQuery("SELECT serie FROM TopFreshSerie s ORDER BY s.serie.notaAvaliacao DESC", Serie.class).setMaxResults(max).getResultList();  
    }
    
    public List<Livro> buscaTopFreshLivro(int max){
        return em.createQuery("SELECT livro FROM TopFreshLivro l ORDER BY l.livro.notaAvaliacao DESC", Livro.class).setMaxResults(max).getResultList();  
    }
}   
