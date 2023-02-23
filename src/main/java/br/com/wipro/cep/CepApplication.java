package br.com.wipro.cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CepApplication {

    public static void main(String[] args) {
        SpringApplication.run(CepApplication.class, args);
    }

}
