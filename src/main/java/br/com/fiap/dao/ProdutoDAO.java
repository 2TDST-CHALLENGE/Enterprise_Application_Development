package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Produto;

public interface ProdutoDAO {

    void cadastrar(Produto produto)

    List<Produto> listar()
};

