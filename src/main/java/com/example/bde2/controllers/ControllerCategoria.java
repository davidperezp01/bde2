package com.example.bde2.controllers;

import com.example.bde2.model.Categoria;
import com.example.bde2.services.CategoriaServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerCategoria implements ErrorController {
    private ErrorAttributes errorAttributes;
    @Autowired
    private CategoriaServiceDB serviceCa;

    private final static String PATH = "/error";

    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "No Mapping Found";
    }

    @GetMapping({"/categorias"})
    public String listar(Model model) {
        model.addAttribute("categorias", serviceCa.findAll()); // inyecta el servicio gracias al @Autowired anterior
        return "categorias";
    }

    @GetMapping("/categorias/newCategorias")
    public String nuevoCategoriaForm(Model model) {
        Categoria p1 = new Categoria();
        model.addAttribute("formCategorias", new Categoria()); //añadimos atributo e instancia del commandobject
        return "newCategorias";
    }

    @PostMapping("/categorias/newCategorias/submit")
    public String nuevoCategoriaSubmit(@ModelAttribute("categoriasForm") Categoria categoria) { // recibimos el command objet a traves de @ModelAttribute que lo coge desde el form y lo inyecta en el atributo empleadoForm
        serviceCa.add(categoria);        //@ModelAttribute realizar un binding de los datos de un formulario de Spring con el servicio.
        return "redirect:/categorias";
    }


    @GetMapping("/categorias/edit/{idCategoria}")                                   //
    public String editarCategoriaForm(@PathVariable int idCategoria, Model model) {  // recibimos id desde el path
        Categoria categoria = serviceCa.findById(idCategoria);                        // pasamos el id al servicio
        if (categoria != null) {
            model.addAttribute("formCategorias", categoria); //añadimos atributo e instancia del commandobject
            return "newCategorias";
        } else {
            return "redirect:/categorias/newCategorias";
        }
    }

    @PostMapping("/categorias/edit/submit")
    public String editarCategoriaSubmit(@ModelAttribute("categoriasForm") Categoria categoria) { // recibimos el command objet a traves de @ModelAttribute que lo coge desde el form y lo inyecta en el atributo empleadoForm
        serviceCa.edit(categoria);       //@ModelAttribute realiza un binding de los datos de un formulario de Spring con el servicio.
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/borrar/{idCategoria}")                                   //
    public String borrarCategoriaForm(@PathVariable int idCategoria) {  // recibimos id desde el path
        Categoria categoria = serviceCa.findById(idCategoria);                        // pasamos el id al servicio
        if (categoria != null) {
            serviceCa.delete(categoria);
            return "redirect:/categorias";
        } else {
            return "redirect:/categorias/newCategorias";
        }
    }


}
