package com.freshonion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="obra_id")
public class Filme extends Obra implements Serializable {
    private static final long serialVersionUID = 1L;
	
    @Column(name = "direcao", nullable = false)
	private String diretores;
	
    @Column(name = "roteiro", nullable = false)
	private String roteiristas;
	
    @Column(name = "producao", nullable = false)
	private String produtores;
	
    public Filme() {
        super();
    }

    public Filme(String poster, String nome, String sinopse, String generos, int anoLancamento, String idioma, String diretores, String roteiristas, String produtores) {
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

    @Override
    public String toString() {
        return "Filme [diretores=" + diretores + ", roteiristas=" + roteiristas + ", produtores=" + produtores
                + ", getPoster()=" + getPoster() + ", getNome()=" + getNome() + ", getSinopse()=" + getSinopse()
                + ", getGenero()=" + getGenero() + ", getAnoLancamento()=" + getAnoLancamento() + ", getIdioma()="
                + getIdioma() + "]";
    }
	
	
}
