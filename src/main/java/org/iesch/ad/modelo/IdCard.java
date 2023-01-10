package org.iesch.ad.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity //Representa la tajeta de identificación universitaria
public class IdCard {

    @Id
    int numero;
    String titulo;
    boolean activo;
    LocalDate fechaCaducidad;

    @OneToOne
    @JoinColumn(name = "person_dni")
    Person person;


    @Override
    public String toString() {
        return "IdCard{" +
                "numero=" + numero +
                ", titulo='" + titulo + '\'' +
                ", activo=" + activo +
                ", fechaCaducidad=" + fechaCaducidad +
                ", person=" +
                '}';
    }
}
