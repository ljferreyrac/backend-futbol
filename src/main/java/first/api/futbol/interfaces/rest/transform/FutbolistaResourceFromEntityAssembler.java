package first.api.futbol.interfaces.rest.transform;

import first.api.futbol.domain.model.entities.Futbolista;
import first.api.futbol.interfaces.rest.resources.FutbolistaResource;

public class FutbolistaResourceFromEntityAssembler {
    public static FutbolistaResource toResourceFromEntity(Futbolista futbolista){
        return new FutbolistaResource(futbolista.getId(), futbolista.getNombres(), futbolista.getApellidos(),
                futbolista.getFechaNacimiento(), futbolista.getCaracteristicas(), futbolista.getPosicion().getPosicion());
    }
}
