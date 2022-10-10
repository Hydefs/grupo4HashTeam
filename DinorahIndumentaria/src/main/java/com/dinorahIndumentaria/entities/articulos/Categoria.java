package com.dinorahIndumentaria.entities.articulos;

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
@Table(name = "categoria")
public class Categoria extends Base {
    private String denominacion;
}
