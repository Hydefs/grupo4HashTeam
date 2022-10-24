package com.dinorahIndumentaria;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracionImagen implements WebMvcConfigurer {

    @Override
    //añadimos los recursos indicandole ademas la ruta en donde se van a aencontrar las imagenes
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        WebMvcConfigurer.super.addResourceHandlers(registry);
        //hacemos referencia a la carpeta en el disco C:
        registry.addResourceHandler("/imagenes/**").addResourceLocations("file:/C:/videojuegos/imagenes/");
    }
}
