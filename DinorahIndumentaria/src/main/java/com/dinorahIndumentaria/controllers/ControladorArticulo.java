package com.dinorahIndumentaria.controllers;

import com.dinorahIndumentaria.entities.articulos.Articulo;
import com.dinorahIndumentaria.services.ServicioArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControladorArticulo {

    @Autowired
    private ServicioArticulo servicioArticulo;

    @GetMapping("/")
    public String index(Model model){
        try{
            List<Articulo> articulos = this.servicioArticulo.findAllByNoOculto();
            return "views/index";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

}
