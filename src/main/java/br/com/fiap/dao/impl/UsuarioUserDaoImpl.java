package br.com.fiap.dao.impl;

import br.com.fiap.dao.UsuarioUserDao;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.EntityNotFoundException;

import javax.persistence.EntityManager;

public class UsuarioUserDaoImpl extends GenericUserDaoImpl<Usuario, Integer> implements UsuarioUserDao {
    public UsuarioUserDaoImpl(EntityManager em){
        super(em);
    }

    @Override
    public Usuario findById(Integer id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public void update(Usuario entidade) {

    }
}
