package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

//GenericDao<Estabelecimento, Produto>

public interface GenericEstDao<E, P>{
    void create(E entidadee);

    E findById(P id) throws EntityNotFoundException;

    void update(E entidade);

    void delete(P id) throws EntityNotFoundException;

    void commit() throws CommitException;
}
