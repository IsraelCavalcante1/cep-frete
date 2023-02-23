package br.com.wipro.cep.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response object for CEP search")
public class ViaCepResponse {
    @ApiModelProperty(example = "01001-000")
    private String cep;

    @ApiModelProperty(example = "Praça da Sé")
    @JsonProperty(value = "logradouro")
    private String street;

    @JsonProperty(value = "complemento")
    @ApiModelProperty(example = "lado ímpar")
    private String complement;

    @JsonProperty(value = "bairro")
    @ApiModelProperty(example = "Sé")
    private String neighborhood;

    @JsonProperty(value = "localidade")
    @ApiModelProperty(example = "São Paulo")
    private String city;

    @JsonProperty(value = "uf")
    @ApiModelProperty(example = "SP")
    private String state;

    public ViaCepResponse() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
