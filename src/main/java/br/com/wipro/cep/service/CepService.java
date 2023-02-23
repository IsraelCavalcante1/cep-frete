package br.com.wipro.cep.service;

import br.com.wipro.cep.controller.request.CepRequest;
import br.com.wipro.cep.controller.response.CepResponse;
import br.com.wipro.cep.controller.response.ViaCepResponse;
import br.com.wipro.cep.exceptions.CepNotFoundException;

public interface CepService {

     CepResponse consultAddressByCep(CepRequest cepRequest) throws CepNotFoundException;

}
