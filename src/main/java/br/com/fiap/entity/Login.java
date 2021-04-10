package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Table(name = "REGISTRO_LOGIN")
public class Login {
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ACESSO")
    private Calendar dataAcesso;
    
    @Column(name = "EMAIL_ACESSADO")
    private Usuario usuario;

    public Calendar getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(Calendar dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
