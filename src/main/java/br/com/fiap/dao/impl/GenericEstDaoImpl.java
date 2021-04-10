package br.com.fiap.dao.impl;

import br.com.fiap.dao.GenericEstDao;
import br.com.fiap.dao.GenericUserDao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class GenericEstDaoImpl<E, P> implements GenericUserDao<E, P> {

    private EntityManager em;
    private Class<E> clazz;

    @SuppressWarnings("unchecked")
    public GenericEstDaoImpl(EntityManager em){
        this.em = em;
        this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void create(E entidade) {
        em.persist(entidade);
    }

    @Override
    public E findById(P id) throws EntityNotFoundException {
        E entidade = em.find(clazz, id);
        if (entidade == null){
            throw new EntityNotFoundException();
        }
        return entidade;
    }

    @Override
    public void update(E entidade) {
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
