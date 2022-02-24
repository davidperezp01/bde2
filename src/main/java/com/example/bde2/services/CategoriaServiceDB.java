package com.example.bde2.services;

import com.example.bde2.model.Categoria;
import com.example.bde2.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceDB implements ICategoriaService{

    @Autowired
    CategoriaRepository repository;

    @Override
    public Categoria add(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    //importar el paquete springframework no el javax
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(int id) {
        //el método orElse controla lo que devuelve en caso de no encontrar el id
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Categoria edit(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        repository.delete(categoria);
    }
}

