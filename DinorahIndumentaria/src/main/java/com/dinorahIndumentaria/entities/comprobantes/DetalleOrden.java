package com.dinorahIndumentaria.entities.comprobantes;

import com.dinorahIndumentaria.entities.Base;
import com.dinorahIndumentaria.entities.articulos.Articulo;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "detalle_orden")
public class DetalleOrden extends Base {
    private int cantidad;
    private double precioTotal;

    @ManyToOne
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
}
