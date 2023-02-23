package br.com.wipro.cep.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response object for CEP search")
public class CepResponse {

    @ApiModelProperty(example = "01001-000")
    private String cep;

    @ApiModelProperty(example = "Praça da Sé")
    private String street;

    @ApiModelProperty(example = "lado ímpar")
    private String complement;

    @ApiModelProperty(example = "Sé")
    private String neighborhood;

    @ApiModelProperty(example = "São Paulo")
    private String city;

    @ApiModelProperty(example = "SP")
    private String state;

    @ApiModelProperty(example = "7.85")
    private Double shippingPrice;


    public CepResponse() {
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

    public void setNeighborhood(String neighbourhood) {
        this.neighborhood = neighbourhood;
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

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }
}
