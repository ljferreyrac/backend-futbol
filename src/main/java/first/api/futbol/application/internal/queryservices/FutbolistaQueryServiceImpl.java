package first.api.futbol.application.internal.queryservices;

import first.api.futbol.domain.model.entities.Futbolista;
import first.api.futbol.domain.model.queries.GetAllFutbolistasQuery;
import first.api.futbol.domain.model.queries.GetFutbolistaByIdQuery;
import first.api.futbol.domain.services.FutbolistaQueryService;
import first.api.futbol.infrastructure.persistence.jpa.repositories.FutbolistaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FutbolistaQueryServiceImpl implements FutbolistaQueryService {

    private final FutbolistaRepository futbolistaRepository;

    public FutbolistaQueryServiceImpl(FutbolistaRepository futbolistaRepository) {
        this.futbolistaRepository = futbolistaRepository;
    }

    @Override
    public Optional<Futbolista> handle(GetFutbolistaByIdQuery query) {
        return futbolistaRepository.findById(query.id());
    }

    @Override
    public Page<Futbolista> handle(GetAllFutbolistasQuery query) {
        return futbolistaRepository.findAll(query.pageable());
    }
}
