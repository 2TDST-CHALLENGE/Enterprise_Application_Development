package br.com.fiap.dao.impl;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.exception.CommitException;

import javax.persistence.EntityManager;

public abstract class GenericDaoImpl<U, E, P> implements GenericDao<U, E, P> {

    private EntityManager em;
    private Class<U> clazz;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl(EntityManager em){
        this.em = em;
        this.clazz = (Class<U>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void create(U entidade) {
        em.persist(entidade);
    }

    @Override
    public U findById(E id) throws EntityNotFoundException {
        U entidade = em.find(clazz, id);
        if (entidade == null){
            throw new EntityNotFoundException();
        }
        return entidade;
    }

    @Override
    public void update(P entidade) {
        em.merge(entidade);
    }

    @Override
    public void delete(P id) throws EntityNotFoundException {
        E entidade = findById(id);
        em.remove(entidade);
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new CommitException();
        }
    }
}
