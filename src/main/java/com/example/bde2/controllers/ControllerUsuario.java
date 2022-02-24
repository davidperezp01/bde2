package com.example.bde2.controllers;

import com.example.bde2.model.Usuario;
import com.example.bde2.services.UsuarioServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerUsuario {


    @Autowired
    private UsuarioServiceDB serviceEm;

    //@Autowired
    // private PoblacionServiceDB servicePob;

    @GetMapping({"/usuarios"})
    public String listar(Model model) {
        model.addAttribute("usuarios", serviceEm.findAll());
        return "usuarios";
    }

}
