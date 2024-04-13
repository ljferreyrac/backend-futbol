package first.api.futbol.domain.model.queries;

import org.springframework.data.domain.Pageable;

public record GetAllFutbolistasQuery(Pageable pageable) {
}
