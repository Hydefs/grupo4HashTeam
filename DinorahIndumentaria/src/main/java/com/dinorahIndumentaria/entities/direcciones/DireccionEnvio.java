package com.dinorahIndumentaria.entities.direcciones;

import com.dinorahIndumentaria.entities.Base;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "direccion_envio")
public class DireccionEnvio extends Base {
    private String calle;
    private String departamento;
    private String localidad;
    private int numero;
    private String piso;
    private String recordatorio;
    private String aclaraciones;
    private String latitud;
    private String longitud;
}
