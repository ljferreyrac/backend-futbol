package first.api.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI futbolPlatformOpenApi(){
        return new OpenAPI()
                .info(new Info().title("Futbol API")
                        .description("Futbol Application RESTful API")
                        .version("v1.0.0"));
    }
}
