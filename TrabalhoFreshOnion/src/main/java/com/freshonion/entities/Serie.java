package com.freshonion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="obra_id")
public class Serie extends Obra implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "direcao", nullable = false)
    private String diretores;
    
    @Column(name = "roteiro", nullable = false)
    private String roteiristas;
    
    @Column(name = "producao", nullable = false)
    private String produtores;
    
    @Column(name = "anoTermino", nullable = true)
    private int anoTermino;
    
    public Serie() {}
    
    public Serie(String poster, String nome, String sinopse, String generos, int anoLancamento, String idioma, String diretores, String roteiristas, String produtores, int anoTermino) {
        super();
        this.setPoster(poster);
        this.setNome(nome);
        this.setSinopse(sinopse);
        this.setGenero(generos);
        this.setAnoLancamento(anoLancamento);
        this.setIdioma(idioma);
        this.diretores = diretores;
        this.roteiristas = roteiristas;
        this.produtores = produtores;
        this.anoTermino = anoTermino;
    }

    public String getDiretores() {
        return diretores;
    }

    public void setDiretores(String diretores) {
        this.diretores = diretores;
    }

    public String getRoteiristas() {
        return roteiristas;
    }

    public void setRoteiristas(String roteiristas) {
        this.roteiristas = roteiristas;
    }

    public String getProdutores() {
        return produtores;
    }

    public void setProdutores(String produtores) {
        this.produtores = produtores;
    }

    public int getAnoTermino() {
        return anoTermino;
    }

    public void setAnoTermino(int anoTermino) {
        this.anoTermino = anoTermino;
    }
}
