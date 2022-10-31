package com.dinorahIndumentaria.repositories;

import com.dinorahIndumentaria.entities.articulos.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioArticulo extends JpaRepository<Articulo, Long> {

    @Query(value = "SELECT * FROM articulo WHERE articulo.oculto = false", nativeQuery = true)
    List<Articulo> findAllByNoOculto();

    @Query(value = "SELECT * FROM articulo WHERE articulo.id = :id AND articulo.oculto = false", nativeQuery = true)
    Optional<Articulo> findByIdAndNoOculto(@Param("id") long id);

    @Query(value = "SELECT * FROM articulo WHERE articulo.nombre = :q AND articulo.oculto = false", nativeQuery = true)
    Optional<Articulo> findByNombre(@Param("q") String q);
}
