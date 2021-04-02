package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CADASTRO_USUARIO")
public class Usuario {
    
    @Id
    @Column(name = "EMAIL", length = 40)
    private String email;
    
    @Column(name = "USERNAME", nullable = false, length = 40)
    private String username;
    
    @Column(name = "PASSWORD", nullable = false, length = 30)
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
