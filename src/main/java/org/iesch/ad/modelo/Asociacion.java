package org.iesch.ad.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Asociacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nombre;

    @OneToMany(mappedBy = "asociacion", cascade = CascadeType.ALL)
    private List<Club> listClubes = new ArrayList<>();

    public void addClub (Club c){
        listClubes.add(c);
    }
}
