package com.freshonion.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TopFreshLivro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public TopFreshLivro() {
        super();
    }
    
    public TopFreshLivro(Livro livro) {
        super();
        this.livro = livro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name="livro_id", nullable=false)
    private Livro livro;
    
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
