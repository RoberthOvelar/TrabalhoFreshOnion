package com.freshonion.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TopFreshFilme implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public TopFreshFilme() {
        super();
    }
    
    public TopFreshFilme(Filme filme) {
        super();
        this.filme = filme;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name="filme_id", nullable=false)
    private Filme filme;
    
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
