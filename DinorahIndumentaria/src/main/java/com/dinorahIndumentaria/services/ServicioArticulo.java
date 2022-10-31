package com.dinorahIndumentaria.services;

import com.dinorahIndumentaria.entities.articulos.Articulo;
import com.dinorahIndumentaria.repositories.RepositorioArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioArticulo implements ServicioBase<Articulo> {

    @Autowired
    private RepositorioArticulo repositorio;

    /*
    * Ver si es conveniente devolver un Map con un error llegado al caso
    * de que exista una Exception
     */
    @Override
    @Transactional
    public List<Articulo> findAll() throws Exception {
        try{
            List<Articulo> articulos = this.repositorio.findAll();
            return articulos;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Articulo findById(long id) throws Exception {
        try{

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return null;
    }

    @Override
    @Transactional
    public Articulo saveOne(Articulo entity) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public Articulo updateOne(Articulo entity, long id) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        return false;
    }

    @Override
    @Transactional
    public boolean disableById(long id) throws Exception {
        return false;
    }

    @Transactional
    public List<Articulo> findAllByNoOculto() throws Exception{
        try {
            List<Articulo> entities = this.repositorio.findAllByNoOculto();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
