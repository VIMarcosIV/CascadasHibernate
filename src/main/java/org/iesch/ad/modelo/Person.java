package org.iesch.ad.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Person {

    @Id
    String dni;
    String name;
    String lastname;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "tarjeta_numero")
    IdCard tarjeta;
}
