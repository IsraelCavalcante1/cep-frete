package br.com.wipro.cep.service.impl;

import br.com.wipro.cep.controller.request.CepRequest;
import br.com.wipro.cep.controller.response.CepResponse;
import br.com.wipro.cep.controller.response.ViaCepResponse;
import br.com.wipro.cep.exceptions.CepNotFoundException;
import br.com.wipro.cep.service.CepService;
import br.com.wipro.cep.service.ShippingService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepServiceImpl implements CepService {
    private final String viaCepUrl = "https://viacep.com.br/ws/";
    private final ShippingService shippingService;

    public CepServiceImpl(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    /**
     * Consults an address by its CEP (postal code) using ViaCEP API
     *
     * @param cepRequest a CepRequest object containing the cep to be searched
     * @return a CepResponse object containing the found address data and the calculated shipping cost
     * @throws CepNotFoundException if the cep is not found or is invalid
     */
    @Override
    public CepResponse consultAddressByCep(CepRequest cepRequest) throws CepNotFoundException {
        String cep = cepRequest.getCep().replace("-", "");
        String url = viaCepUrl + cep + "/json/";

        ViaCepResponse viaCepResponse = restTemplate(new RestTemplateBuilder()).getForObject(url, ViaCepResponse.class);

        if (viaCepResponse == null || viaCepResponse.getCep() == null) {
            throw new CepNotFoundException("CEP not found");
        }

        String state = viaCepResponse.getState();
        Double shippingCost = shippingService.calculateShippingCostByState(state);

        CepResponse cepResponse = new CepResponse();
        cepResponse.setCep(viaCepResponse.getCep());
        cepResponse.setStreet(viaCepResponse.getStreet());
        cepResponse.setComplement(viaCepResponse.getComplement());
        cepResponse.setNeighborhood(viaCepResponse.getNeighborhood());
        cepResponse.setCity(viaCepResponse.getCity());
        cepResponse.setState(state);
        cepResponse.setShippingPrice(shippingCost);

        return cepResponse;
    }

    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}