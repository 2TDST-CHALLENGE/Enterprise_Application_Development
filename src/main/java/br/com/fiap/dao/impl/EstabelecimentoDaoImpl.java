package br.com.fiap.dao.impl;

import br.com.fiap.dao.EstabelecimentoDao;
import br.com.fiap.entity.Estabelecimento;
import br.com.fiap.exception.EntityNotFoundException;

import javax.persistence.EntityManager;

public class EstabelecimentoDaoImpl extends GenericEstDaoImpl<Estabelecimento, Integer> implements EstabelecimentoDao {
    public EstabelecimentoDaoImpl(EntityManager em){
        super(em);
    }

    @Override
    public Estabelecimento findById(Integer id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public void update(Estabelecimento entidade) {

    }
}
