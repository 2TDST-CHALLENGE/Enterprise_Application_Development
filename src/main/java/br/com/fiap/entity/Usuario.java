package br.com.fiap.entity;

import javax.persistence.*;

@Entity
@Table(name = "CADASTRO_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
public class Usuario {
    
    @Id
    @Column(name = "EMAIL", length = 40)
    private String email;
    
    @Column(name = "USERNAME", nullable = false, length = 40)
    private String username;
    
    @Column(name = "PASSWORD", nullable = false, length = 30)
    private String senha;

    public Usuario(){}

    public Usuario(String email, String username, String senha) {
        this.email = email;
        this.username = username;
        this.senha = senha;
    }

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
