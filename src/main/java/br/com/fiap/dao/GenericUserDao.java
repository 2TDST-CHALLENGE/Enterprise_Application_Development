package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

//GenericDao<Usuário, Estabelecimento>

public interface GenericUserDao<U, E> {

    void create(U entidadee);

    U findById(E id) throws EntityNotFoundException;

    void update(U entidade);

    void delete(E id) throws EntityNotFoundException;

    void commit() throws CommitException;
}
