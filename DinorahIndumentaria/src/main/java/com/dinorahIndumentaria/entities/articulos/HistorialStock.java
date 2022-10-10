package com.dinorahIndumentaria.entities.articulos;

import com.dinorahIndumentaria.entities.Base;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "historial_stock")
public class HistorialStock extends Base {
    private Date fechaMovimiento;
    private int cantidad;
    @Column(columnDefinition = "boolean default false")
    private boolean operacion;
}
