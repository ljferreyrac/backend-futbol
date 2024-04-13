package first.api.futbol.interfaces.rest.resources;

import java.time.LocalDate;

public record FutbolistaResource(Long id,
        String nombres,
        String apellidos,
        LocalDate fechaNacimiento,
        String caracteristicas,
        String posicion) {
}
