package com.dinorahIndumentaria.repositories;

import com.dinorahIndumentaria.entities.articulos.Articulo;
import com.dinorahIndumentaria.entities.articulos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM categoria WHERE categoria.oculto = false", nativeQuery = true)
    List<Categoria> findAllByNoOculto();

    @Query(value = "SELECT * FROM categoria WHERE categoria.id = :id AND categoria.oculto = false", nativeQuery = true)
    Optional<Categoria> findByIdAndNoOculto(@Param("id") long id);

}
