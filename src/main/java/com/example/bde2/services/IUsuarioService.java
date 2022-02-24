package com.example.bde2.services;

import com.example.bde2.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario add(Usuario usuario);
    List<Usuario>findAll();
    Usuario findById(int id);
    Usuario edit(Usuario usuario);
    void delete(Usuario usuario);
    Usuario findByName(String nombre);
}
