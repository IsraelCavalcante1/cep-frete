package br.com.wipro.cep;

import br.com.wipro.cep.controller.request.CepRequest;
import br.com.wipro.cep.controller.response.CepResponse;
import br.com.wipro.cep.exceptions.CepNotFoundException;
import br.com.wipro.cep.service.impl.CepServiceImpl;
import br.com.wipro.cep.service.impl.ShippingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CepServiceTest {

    private CepServiceImpl cepService;

    @BeforeEach
    void setUp() {

        cepService = new CepServiceImpl(new ShippingServiceImpl() {
        });
    }

    @Test
    void consultAddressByCep_ValidCep_ReturnsCepResponse() throws CepNotFoundException {
        CepRequest cepRequest = new CepRequest();
        cepRequest.setCep("01001000");

        CepResponse cepResponse = cepService.consultAddressByCep(cepRequest);

        Assertions.assertNotNull(cepResponse);
        assertEquals("01001000", cepResponse.getCep().replace("-", ""));
        assertEquals("Praça da Sé", cepResponse.getStreet());
        assertEquals("lado ímpar", cepResponse.getComplement());
        assertEquals("Sé", cepResponse.getNeighborhood());
        assertEquals("São Paulo", cepResponse.getCity());
        assertEquals("SP", cepResponse.getState());
        assertEquals(7.85, cepResponse.getShippingPrice());
    }

    @Test
    void consultAddressByCep_InvalidCep_ThrowsCepNotFoundException() {
        CepRequest cepRequest = new CepRequest();
        cepRequest.setCep("00000000");

        assertThrows(CepNotFoundException.class, () -> {
            cepService.consultAddressByCep(cepRequest);
        });
    }

    @Test
    public void testConsultAddressByCepWithInvalidCep() throws CepNotFoundException {
        CepRequest cepRequest = new CepRequest("12345678"); // CEP inválido
        assertThrows(CepNotFoundException.class, () -> cepService.consultAddressByCep(cepRequest));
    }


}
