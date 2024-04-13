package first.api.futbol.domain.services;

import first.api.futbol.domain.model.entities.Futbolista;
import first.api.futbol.domain.model.queries.GetAllFutbolistasQuery;
import first.api.futbol.domain.model.queries.GetFutbolistaByIdQuery;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface FutbolistaQueryService {
    Optional<Futbolista> handle(GetFutbolistaByIdQuery query);
    Page<Futbolista> handle(GetAllFutbolistasQuery query);
}
