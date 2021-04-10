package br.com.fiap.dao.impl;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Estabelecimento;
import br.com.fiap.entity.Usuario;

import javax.persistence.EntityManager;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Estabelecimento, Integer> implements UsuarioDao {
    public UsuarioDaoImpl(EntityManager em){
        super(em);
    }
}
