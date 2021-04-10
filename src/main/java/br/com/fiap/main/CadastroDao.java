package br.com.fiap.main;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dao.impl.UsuarioDaoImpl;
import br.com.fiap.entity.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class CadastroDao {

    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
        EntityManager em = fabrica.createEntityManager();

        UsuarioDao dao = new UsuarioDaoImpl(em);

        Usuario usuario = new Usuario("allanpreis@gmail.com", "allanpreis", "156795");
        try{
            dao.create(usuario);
            dao.commit();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Inscreva-se", 1);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Inscreva-se", 1);
        }
    }
}
