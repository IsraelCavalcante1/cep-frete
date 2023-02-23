package br.com.wipro.cep.controller.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CepRequest {

    @NotBlank(message = "CEP is required")
    @Pattern(regexp = "^\\d{8}$|^\\d{5}-\\d{3}$", message = "Invalid CEP format")
    @ApiModelProperty(value = "The CEP to be validated. Can be either 8 digits or 5 digits followed by a dash and 3 digits.", required = true, example = "12239-320")
    private String cep;


    public CepRequest(String cep) {
        this.cep = cep;
    }
    public CepRequest() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}



