package br.com.fiap.dao.impl;

import br.com.fiap.dao.GenericUserDao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class GenericUserDaoImpl<U, E> implements GenericUserDao<U, E> {

    private EntityManager em;
    private Class<U> clazz;

    @SuppressWarnings("unchecked")
    public GenericUserDaoImpl(EntityManager em){
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
    public void update(U entidade) {
        em.merge(entidade);
    }

    @Override
    public void delete(E id) throws EntityNotFoundException {
        U entidade = findById(id);
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
