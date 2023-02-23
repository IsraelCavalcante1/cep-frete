package br.com.wipro.cep;

import br.com.wipro.cep.service.impl.ShippingServiceImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShippingServiceImplTest {

    private ShippingServiceImpl shippingServiceImpl = new ShippingServiceImpl();

    @Test
    public void testCalculateShippingCostByStateSoutheast() {
        Double expected = 7.85;
        Double actual = shippingServiceImpl.calculateShippingCostByState("SP");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShippingCostByStateCenterWest() {
        Double expected = 12.50;
        Double actual = shippingServiceImpl.calculateShippingCostByState("DF");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShippingCostByStateNortheast() {
        Double expected = 15.98;
        Double actual = shippingServiceImpl.calculateShippingCostByState("BA");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShippingCostByStateSouth() {
        Double expected = 17.30;
        Double actual = shippingServiceImpl.calculateShippingCostByState("SC");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShippingCostByStateNorth() {
        Double expected = 20.83;
        Double actual = shippingServiceImpl.calculateShippingCostByState("AM");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShippingCostByStateInvalid() {
        Double expected = 0.0;
        Double actual = shippingServiceImpl.calculateShippingCostByState("XY");
        assertEquals(expected, actual);
    }
}
