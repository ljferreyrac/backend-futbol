package first.api.futbol.interfaces.rest;

import first.api.futbol.domain.model.entities.Futbolista;
import first.api.futbol.domain.model.queries.GetAllFutbolistasQuery;
import first.api.futbol.domain.model.queries.GetFutbolistaByIdQuery;
import first.api.futbol.domain.services.FutbolistaQueryService;
import first.api.futbol.interfaces.rest.resources.FutbolistaResource;
import first.api.futbol.interfaces.rest.transform.FutbolistaResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/futbolista", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Futbolistas", description = "Futbolista Management Endpoints")
public class FutbolistaController {
    private final FutbolistaQueryService futbolistaQueryService;

    public FutbolistaController(FutbolistaQueryService futbolistaQueryService) {
        this.futbolistaQueryService = futbolistaQueryService;
    }

    @Getter
    @Setter
    public static class FutbolistaResponse {
        private List<FutbolistaResource> futbolistas;
        private Boolean first;
        private Boolean last;
        private Integer totalPages;
    }

    @GetMapping
    public ResponseEntity<FutbolistaResponse> getAllFutbolistas(@PageableDefault Pageable pageable){
        var getAllFutbolistasQuery = new GetAllFutbolistasQuery(pageable);
        Page<Futbolista> page = futbolistaQueryService.handle(getAllFutbolistasQuery);
        if(page.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var futbolistasResources = page.getContent().stream().map(FutbolistaResourceFromEntityAssembler::toResourceFromEntity).toList();
        var response = new FutbolistaResponse();
        response.setFutbolistas(futbolistasResources);
        response.setFirst(page.isFirst());
        response.setLast(page.isLast());
        response.setTotalPages(page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FutbolistaResource> getFutbolistaById(@PathVariable Long id){
        var getFutbolistaByIdQuery = new GetFutbolistaByIdQuery(id);
        var futbolista = futbolistaQueryService.handle(getFutbolistaByIdQuery);
        if(futbolista.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var futbolistaResource = FutbolistaResourceFromEntityAssembler.toResourceFromEntity(futbolista.get());
        return ResponseEntity.ok(futbolistaResource);
    }
}
