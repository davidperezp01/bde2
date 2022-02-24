package com.example.bde2.services;

import com.example.bde2.model.Producto;
import com.example.bde2.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceDB implements IProductoService{

    @Autowired
    ProductoRepository repository;

    @Override
    public Producto add(Producto producto) {
        return repository.save(producto);
    }

    @Override
    //importar el paquete springframework no el javax
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(int id) {
        //el método orElse controla lo que devuelve en caso de no encontrar el id
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto edit(Producto producto) {
        return repository.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        repository.delete(producto);
    }
}
