package br.com.wipro.cep.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CepFreteAPI")
                        .version("1.0.0")
                        .description("Serviço disponibilizado para que o usuário final consiga calcular o frete de acordo com sua região")
                        .contact(new Contact()
                                .name("Israel Campos")
                                .email("leopontorua@gmail.com")
                                .url("http:/localhost:8080")));
    }

}
