package com.dinorahIndumentaria.entities.articulos;

import com.dinorahIndumentaria.entities.Base;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "articulo")
public class Articulo extends Base {
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistorialStock> historialStock;
}
