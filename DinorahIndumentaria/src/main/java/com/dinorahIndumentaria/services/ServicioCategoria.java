package com.dinorahIndumentaria.services;

import com.dinorahIndumentaria.entities.articulos.Categoria;
import com.dinorahIndumentaria.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCategoria implements ServicioBase<Categoria> {

    @Autowired
    private RepositorioCategoria repositorio;

    /*
    * Ver si es conveniente devolver un Map con un error llegado al caso
    * de que exista una Exception
     */
    @Override
    @Transactional
    public List<Categoria> findAll() throws Exception {
        try{
            List<Categoria> categorias = this.repositorio.findAll();
            return categorias;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria findById(long id) throws Exception {
        try{
            Optional<Categoria> opt = this.repositorio.findById(id);
            return opt.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria saveOne(Categoria entity) throws Exception {
        try{
            Categoria categoria = this.repositorio.save(entity);
            return categoria;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    @Transactional
    public Categoria updateOne(Categoria entity, long id) throws Exception {
        try {
            Optional<Categoria> opt = this.repositorio.findById(id);
            Categoria categoria = opt.get();
            categoria = this.repositorio.save(entity);
            return categoria;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Categoria> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Categoria categoria = opt.get();
                categoria.setEliminado(!categoria.isEliminado());
                this.repositorio.save(categoria);
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
            Optional<Categoria> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Categoria categoria = opt.get();
                categoria.setOculto(!categoria.isOculto());
                this.repositorio.save(categoria);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Categoria> findAllByNoOculto() throws Exception{
        try {
            List<Categoria> entities = this.repositorio.findAllByNoOculto();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
