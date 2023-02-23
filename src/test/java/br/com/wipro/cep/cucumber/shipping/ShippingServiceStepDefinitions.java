package br.com.wipro.cep.cucumber.shipping;

import br.com.wipro.cep.service.ShippingService;
import br.com.wipro.cep.service.impl.ShippingServiceImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShippingServiceStepDefinitions {
    private ShippingService shippingService;
    private String state;
    private Double shippingCost;

    @Before
    public void setUp() {
        shippingService = new ShippingServiceImpl();
    }

    @Given("^the state is \"([^\"]*)\"$")
    public void setState(String state) {
        this.state = state;
    }

    @When("^I calculate the shipping cost$")
    public void calculateShippingCost() {
        shippingCost = shippingService.calculateShippingCostByState(state);
    }

    @Then("^the shipping cost should be ([\\d.]+)$")
    public void verifyShippingCost(Double expectedCost) {
        assertEquals(expectedCost, shippingCost);
    }
}
