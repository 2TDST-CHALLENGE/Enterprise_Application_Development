package br.com.fiap.dao;
import br.com.fiap.exception.CommitException;
import javax.persistence.EntityNotFoundException;

//GenericDao<Usuário, Estabelecimento, Produto>

public interface GenericDao<U, E, P> {

    void create(U entidade);

    U findById(E id) throws EntityNotFoundExpection;

    void update()
}
