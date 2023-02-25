package com.freshonion.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Obra{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Lob
    @Column(name = "poster", nullable = false)
    private String poster;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Lob
	@Column(name = "sinopse", nullable = false)
	private String sinopse;
	
	@Column(name = "generos", nullable = false)
	private String generos;
	
	@Column(name = "ano_lancamento", nullable = false)
	private int anoLancamento;
	
	@Column(name = "idioma", nullable = false)
    private String idioma;
	
	@Column(name = "nota", nullable = true)
	private Float notaAvaliacao;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "obra_id") }, inverseJoinColumns = { @JoinColumn(name = "critica_id") })
	private List<Critica> criticas;
	
	public Obra() {
        super();
    }
	
	public Obra(int id, String poster, String nome, String sinopse, String generos, int anoLancamento, String idioma, Float notaAvaliacao) {
        super();
        this.id = id;
        this.poster = poster;
        this.nome = nome;
        this.sinopse = sinopse;
        this.generos = generos;
        this.anoLancamento = anoLancamento;
        this.idioma = idioma;
        this.notaAvaliacao = notaAvaliacao;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return generos;
	}

	public void setGenero(String generos) {
		this.generos = generos;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
	
	public Float getNotaAvaliacao() {
		return notaAvaliacao;
	}

	public void setNotaAvaliacao(Float notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}
	
	public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }
}
