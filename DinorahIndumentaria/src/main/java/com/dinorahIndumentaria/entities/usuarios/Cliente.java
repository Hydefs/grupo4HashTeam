package com.dinorahIndumentaria.entities.usuarios;

import com.dinorahIndumentaria.entities.direcciones.DireccionEnvio;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DiscriminatorValue(value = "cliente")
public class Cliente extends Usuario{
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DireccionEnvio> direccionesEnvio;
}
