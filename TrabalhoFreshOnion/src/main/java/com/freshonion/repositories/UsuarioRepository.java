package com.freshonion.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.freshonion.entities.Usuario;

@Stateless
public class UsuarioRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FreshOnionUnit");
    EntityManager em = emf.createEntityManager();
    
    public Usuario buscaUsuario(String email) {
        return em.find(Usuario.class, email);
    }
}
