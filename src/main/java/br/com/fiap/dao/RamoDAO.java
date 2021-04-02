package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Ramo;

public interface RamoDAO {

    void cadastrar(Ramo ramo);

    List<Ramo> listar();
}
