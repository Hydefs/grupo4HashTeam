package com.dinorahIndumentaria.services;

import com.dinorahIndumentaria.entities.articulos.Articulo;
import com.dinorahIndumentaria.repositories.RepositorioArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
            Optional<Articulo> opt = this.repositorio.findById(id);
            return opt.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Articulo saveOne(Articulo entity) throws Exception {
        try{
            Articulo articulo = this.repositorio.save(entity);
            return articulo;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    @Transactional
    public Articulo updateOne(Articulo entity, long id) throws Exception {
        try {
            Optional<Articulo> opt = this.repositorio.findById(id);
            Articulo articulo = opt.get();
            articulo = this.repositorio.save(entity);
            return articulo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Articulo> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Articulo articulo = opt.get();
                articulo.setEliminado(!articulo.isEliminado());
                this.repositorio.save(articulo);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean disableById(long id) throws Exception {
        try {
            Optional<Articulo> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Articulo articulo = opt.get();
                articulo.setOculto(!articulo.isOculto());
                this.repositorio.save(articulo);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
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
