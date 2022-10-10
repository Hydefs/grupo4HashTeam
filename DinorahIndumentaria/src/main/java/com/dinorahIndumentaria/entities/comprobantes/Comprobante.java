package com.dinorahIndumentaria.entities.comprobantes;

import com.dinorahIndumentaria.entities.Base;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "comprobante")
public class Comprobante extends Base {

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String formaPago;
    private double total;

    @ManyToOne
    @JoinColumn(name = "fk_estado")
    private Estado estado;
}
