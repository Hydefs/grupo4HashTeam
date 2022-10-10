package com.dinorahIndumentaria.entities.comprobantes;

import com.dinorahIndumentaria.entities.direcciones.DireccionEnvio;
import com.dinorahIndumentaria.entities.usuarios.Cliente;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orden")
public class Orden extends Comprobante{
    private String aclaraciones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrden> detalles;

    @Column(columnDefinition = "boolean default false")
    private boolean envio;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fk_direccion_entrega")
    private DireccionEnvio direccionEnvio;
}
