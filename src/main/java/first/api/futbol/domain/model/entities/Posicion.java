package first.api.futbol.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String posicion;

    @OneToMany(mappedBy = "posicion")
    private List<Futbolista> futbolistas;
}
