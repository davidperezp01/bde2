package com.example.bde2.services;

import com.example.bde2.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto add(Producto producto );
    List<Producto> findAll();
    Producto findById(int id);
    Producto edit(Producto producto);
    void delete(Producto producto);
}
