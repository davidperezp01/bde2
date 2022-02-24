package com.example.bde2.services;

import com.example.bde2.model.Categoria;

import java.util.List;

public interface ICategoriaService {
    Categoria add(Categoria categoria );
    List<Categoria> findAll();
    Categoria findById(int id);
    Categoria edit(Categoria categoria);
    void delete(Categoria categoria);
}

