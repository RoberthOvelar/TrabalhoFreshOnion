package com.freshonion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Id
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "senha", nullable = false)
    private String senha;
    
    @Type(type="true_false")
    @Column(name = "admin", nullable = false)
    private boolean admin;
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean getAdmin() {
        return admin;
    }

    public void getAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", email=" + email + "]";
    }
}
