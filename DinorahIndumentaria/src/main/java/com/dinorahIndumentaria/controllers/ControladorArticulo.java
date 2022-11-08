package com.dinorahIndumentaria.controllers;

import com.dinorahIndumentaria.entities.articulos.Articulo;
import com.dinorahIndumentaria.services.ServicioArticulo;
import com.dinorahIndumentaria.services.ServicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

@Controller
public class ControladorArticulo {

    @Autowired
    private ServicioArticulo servicioArticulo;

    @Autowired
    private ServicioCategoria servicioCategoria;

    @GetMapping("/")
    public String index(Model model) {
        try {
            List<Articulo> articulos = this.servicioArticulo.findAllByNoOculto();
            return "views/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/productos/carga_productos/{id}")
    public String formularioArticulo(Model model, @PathVariable("id") long id){
        try {
            //En este caso tenemos que añadir al modelo  la categoria ya que las vamos a
            //asociar a nuestro articulo en el formulario
            model.addAttribute("categorias",this.servicioCategoria.findAll());
            if(id==0){
                model.addAttribute("articulo", new Articulo());
            }else{
                model.addAttribute("articulo", this.servicioArticulo.findById(id));
            }
            return "views/formulario/carga_productos";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/productos/carga_productos/{id}")
    /* Primero anotamos como @requestParam el archivo que tendra que ser de tipo MultipartFile.
       Para este archivo usamos la clase de File.write para escribir, y para el nombre
       del archivo usamos el String extension
       Despues indicamos que la extencion es = al . + el nombre del archivo desde el index del .
       Con el String nombreFoto obtenemos el tiempo en milis para que sea unico + la extención
     */

    public String guardarArticulo(
            @RequestParam("archivo") MultipartFile archivo,
            @Validated @ModelAttribute("articulo")Articulo articulo,
            BindingResult result,
            Model model, @PathVariable("id") long id){
        try {

            model.addAttribute("categorias",this.servicioCategoria.findAll());
            if(result.hasErrors()){
                return "views/formulario/carga_productos";
            }
            String ruta = "C://videojuegos/imagenes";

            int index = archivo.getOriginalFilename().indexOf("."); //= jpg / png /etc
            String extencion="";
            extencion = "." + archivo.getOriginalFilename().substring(index+1);
            String nombreFoto = Calendar.getInstance().getTimeInMillis()+extencion;
            // si el id  != 0 significa que ya tiene una imagen asociada y retornamos el path
            // del la imagen del videojuego
            // para pisarla, caso contrario obtenemos la ruta + el nombre de la foto
            Path rutaAbsoluta = id != 0 ? Paths.get(ruta + "//" + articulo.getImagen()) :
                    Paths.get(ruta +"//" + nombreFoto);
            if(id==0){
                if (archivo.isEmpty()){
                    model.addAttribute("imageErrorMsg","Se requiere subir una imagen");
                    return "views/formulario/carga_productos";
                }
                if(!this.validarExtencion(archivo)){

                    model.addAttribute("imageErrorMsg","La extension no es valida");
                    return "views/formulario/carga_productos";
                }
                if (archivo.getSize()>15000000){
                    model.addAttribute("imageErrorMsg","El archivo es demasiado grande, limite 15MB");
                    return "views/formulario/carga_productos";
                }

                Files.write(rutaAbsoluta,archivo.getBytes());
                //Finalmente al archivo le seteamos el nombre de la foto que seria
                // un numero largo + la extención .jpeg o etc
                articulo.setImagen(nombreFoto);
                this.servicioArticulo.saveOne(articulo);
            }else{
                if(!archivo.isEmpty()){ // si la imagen no esta vacia hacemos un write con la ruta y los bytes
                    if(!this.validarExtencion(archivo)){
                        model.addAttribute("imageErrorMsg","La extension no es valida");
                        return "views/formulario/carga_productos";
                    }
                    if (archivo.getSize()>15000000){
                        model.addAttribute("imageErrorMsg","El archivo es demasiado grande, limite 15MB");
                        return "views/formulario/carga_productos";
                    }
                    Files.write(rutaAbsoluta,archivo.getBytes());
                }
                this.servicioArticulo.updateOne(articulo,id);
            }

            return "error"; //return "redirect:/crud";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    public boolean validarExtencion(MultipartFile archivo){

        try {
            ImageIO.read(archivo.getInputStream()).toString();
            return true;

        }catch (Exception e){

            return false;
        }
    }

}
