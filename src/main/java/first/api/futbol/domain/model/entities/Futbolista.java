package first.api.futbol.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class Futbolista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;

    private String apellidos;

    private LocalDate fechaNacimiento;

    private String caracteristicas;

    @ManyToOne
    private Posicion posicion;

    public Futbolista() {
    }
}
