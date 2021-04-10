package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import javax.persistence.EntityNotFoundException;

//GenericDao<Usuário, Estabelecimento, Produto>

public interface GenericDao<U, E, P> {

    void create(U entidade);

    U findById(E id) throws EntityNotFoundException;

    void update(P entidade);

    void delete(P id);

    void commit() throws CommitException;
}
