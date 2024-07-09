package api.prueba.brasilia.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Prueba - Empresa Brasilia")
                        .description("Esta es una API de prueba desarrollada para el proceso de selección en la empresa Brasilia.")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Miguel Zambrano Herrera")
                                .url("https://github.com/Devmiguelz")
                                .email("zmiguel96@gmail.com"))
                        .license(new License()
                                .name("Licencia Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación Externa")
                        .url("https://springdoc.org/"));
    }
}
