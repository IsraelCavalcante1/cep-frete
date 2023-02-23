package br.com.wipro.cep.cucumber.cep;

import br.com.wipro.cep.controller.request.CepRequest;
import br.com.wipro.cep.controller.response.CepResponse;
import br.com.wipro.cep.exceptions.CepNotFoundException;
import br.com.wipro.cep.service.impl.CepServiceImpl;
import br.com.wipro.cep.service.impl.ShippingServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CepServiceStepDefinitions {

    private CepServiceImpl cepService;
    private CepRequest cepRequest;
    private CepResponse cepResponse;
    private Exception exception;

    public CepServiceStepDefinitions() {
        ShippingServiceImpl shippingService = new ShippingServiceImpl();
        cepService = new CepServiceImpl(shippingService);
    }

    @Given("^a CEP \"([^\"]*)\"$")
    public void givenValidCep(String cep) {
        cepRequest = new CepRequest();
        cepRequest.setCep(cep);
    }

    @Given("^an invalid CEP \"([^\"]*)\"$")
    public void givenInvalidCep(String cep) {
        cepRequest = new CepRequest();
        cepRequest.setCep(cep);
    }

    @When("^I consult the address$")
    public void consultAddressByCep() {
        try {
            cepResponse = cepService.consultAddressByCep(cepRequest);
        } catch (CepNotFoundException e) {
            exception = e;
        }
    }

    @Then("^the response should contain the address data and shipping cost$")
    public void thenResponseContainsAddressDataAndShippingCost() {
        Assert.assertNotNull(cepResponse);
        Assert.assertNotNull(cepResponse.getCep());
        Assert.assertNotNull(cepResponse.getStreet());
        Assert.assertNotNull(cepResponse.getComplement());
        Assert.assertNotNull(cepResponse.getNeighborhood());
        Assert.assertNotNull(cepResponse.getCity());
        Assert.assertNotNull(cepResponse.getState());
        Assert.assertNotNull(cepResponse.getShippingPrice());
    }

    @Then("^an exception should be thrown$")
    public void thenExceptionIsThrown() {
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof CepNotFoundException);
    }

}
