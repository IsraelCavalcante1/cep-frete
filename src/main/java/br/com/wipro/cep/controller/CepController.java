package br.com.wipro.cep.controller;

import javax.validation.Valid;

import br.com.wipro.cep.exceptions.CepNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wipro.cep.controller.request.CepRequest;
import br.com.wipro.cep.controller.response.CepResponse;
import br.com.wipro.cep.service.CepService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService cepService;

    @Autowired
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @ApiOperation(value = "Find address by CEP")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CepResponse.class),
            @ApiResponse(code = 400, message = "CEP invalid format"),
            @ApiResponse(code = 404, message = "CEP not found")
    })
    @GetMapping("")
    public CepResponse findAddressByCep(@RequestBody @Valid CepRequest cepRequest) throws CepNotFoundException {
       return cepService.consultAddressByCep(cepRequest);
    }
}
