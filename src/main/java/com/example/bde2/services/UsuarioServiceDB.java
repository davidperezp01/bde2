package com.example.bde2.services;

import com.example.bde2.model.Usuario;
import com.example.bde2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceDB implements IUsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public Usuario add(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    //importar el paquete springframework no el javax
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(int id) {
        //el método orElse controla lo que devuelve en caso de no encontrar el id
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuario edit(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        repository.delete(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public Usuario findByName(String nombre){
        return repository.findByName(nombre);
    }
}

