package com.example.bde2.controllers;

import com.example.bde2.model.Producto;
import com.example.bde2.services.CategoriaServiceDB;
import com.example.bde2.services.ProductoServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerProducto {

    @Autowired
    private ProductoServiceDB servicePr;

    @Autowired
    private CategoriaServiceDB serviceCa;

    @GetMapping({"/productos"})
    public String listar(Model model) {
        model.addAttribute("productos", servicePr.findAll());
        return "productos";
    }

    @GetMapping("/productos/newProducto")
    public String nuevoProductoForm(Model model) {
        model.addAttribute("formProductos", new Producto());
        model.addAttribute("categorias", serviceCa.findAll());
        return "newProducto";
    }

    @GetMapping("/productos/edit/{idProducto}")
    public String editarProductoForm(@PathVariable int idProducto, Model model) {
        Producto producto = servicePr.findById(idProducto);
        if (producto != null) {
            model.addAttribute("formProductos", producto);
            model.addAttribute("categorias", serviceCa.findAll());
            return "newProducto";
        } else {
            return "redirect:/producto/newProducto";
        }
    }

    @PostMapping("/productos/newProducto/submit")
    public String nuevoProductoSubmit(@ModelAttribute("formProductos") Producto producto) {
        servicePr.add(producto);
        return "redirect:/productos";
    }

    @PostMapping("/productos/edit/submit")
    public String editarProductoSubmit(@ModelAttribute("formProductos") Producto producto) {
        servicePr.edit(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/borrar/{idProducto}")
    public String borrarProductoForm(@PathVariable int idProducto) {
        String url = "";
        Producto producto = servicePr.findById(idProducto);
        if (producto != null) {
            servicePr.delete(producto);
            url = "redirect:/productos";
        } else {
            url = "redirect:/productos/newProducto";
        }
        return url;
    }

    @GetMapping("/")
    public String catalogo(Model model) {
        model.addAttribute("productos", servicePr.findAll());
        return "index";
    }

    @GetMapping("/catalogouser")
    public String catalogoUser(Model model) {
        model.addAttribute("productos", servicePr.findAll());
        return "catalogouser";
    }
}