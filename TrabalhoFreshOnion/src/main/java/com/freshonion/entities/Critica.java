package com.freshonion.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Critica implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Critica() {
        super();
    }
    
    public Critica(float nota, String analise, Date dataDePostagem, Usuario usuario) {
        super();
        this.nota = nota;
        this.analise = analise;
        this.dataDePostagem = dataDePostagem;
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @Column(name = "nota", nullable = false)
    private float nota;
    
    @Lob
    @Column(name = "analise", nullable = false)
    private String analise;
    
    @Column(name = "dataPostagem", nullable = false)
    private Date dataDePostagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public Date getDataDePostagem() {
        return dataDePostagem;
    }

    public void setDataDePostagem(Date dataDePostagem) {
        this.dataDePostagem = dataDePostagem;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Critica [usuario=" + usuario + ", nota=" + nota + ", analise=" + analise
                + ", dataDePostagem=" + dataDePostagem + "]";
    }
}
