package com.dinorahIndumentaria.entities.usuarios;

import com.dinorahIndumentaria.entities.Base;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario extends Base {
    private Date alta;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
