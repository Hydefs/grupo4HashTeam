package com.dinorahIndumentaria.entities.comprobantes;

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
@Table(name = "estado")
public class Estado extends Base {
    private String estado;
}
