package com.freshonion.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TopFreshSerie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public TopFreshSerie() {
        super();
    }
    
    public TopFreshSerie(Serie serie) {
        super();
        this.serie = serie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name="livro_id", nullable=false)
    private Serie serie;
    
    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}