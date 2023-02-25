package com.freshonion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="obra_id")
public class Livro extends Obra implements Serializable {
private static final long serialVersionUID = 1L;
    
    public Livro() {}

    public Livro(String poster, String nome, String sinopse, String generos, int anoLancamento, String idioma, String escritores, String editora, String numeroPag) {
        super();
        this.setPoster(poster);
        this.setNome(nome);
        this.setSinopse(sinopse);
        this.setGenero(generos);
        this.setAnoLancamento(anoLancamento);
        this.setIdioma(idioma);
        this.escritores = escritores;
        this.editora = editora;
        this.numeroPag = numeroPag;
    }

    @Column(name = "direcao", nullable = false)
    private String escritores;
    
    @Column(name = "editora", nullable = false)
    private String editora;
    
    @Column(name = "numeroPag", nullable = false)
    private String numeroPag;

    public String getEscritores() {
        return escritores;
    }

    public void setEscritores(String escritores) {
        this.escritores = escritores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getNumeroPag() {
        return numeroPag;
    }

    public void setNumeroPag(String numeroPag) {
        this.numeroPag = numeroPag;
    }
}
