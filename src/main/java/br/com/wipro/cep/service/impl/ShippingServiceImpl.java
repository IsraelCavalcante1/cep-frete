package br.com.wipro.cep.service.impl;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShippingServiceImpl implements br.com.wipro.cep.service.ShippingService {
    private final Double freteSudeste = 7.85;
    private final Double freteCentroOeste = 12.50;
    private final Double freteNortheast = 15.98;
    private final Double freteSouth = 17.30;
    private final Double freteNorth = 20.83;

    /**
     * Calculates the shipping cost based on the state of the address
     *
     * @param state a string containing the abbreviation of the state of the address
     * @return a double containing the calculated shipping cost
     */
    public Double calculateShippingCostByState(String state) {
        List<String> southeast = Arrays.asList("SP", "RJ", "ES", "MG");
        List<String> centerWest = Arrays.asList("DF", "GO", "MT", "MS");
        List<String> northeast = Arrays.asList("AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE");
        List<String> south = Arrays.asList("PR", "RS", "SC");
        List<String> north = Arrays.asList("AC", "AM", "AP", "PA", "RO", "RR", "TO");

        if (southeast.contains(state)) {
            return freteSudeste;
        } else if (centerWest.contains(state)) {
            return freteCentroOeste;
        } else if (northeast.contains(state)) {
            return freteNortheast;
        } else if (south.contains(state)) {
            return freteSouth;
        } else if (north.contains(state)) {
            return freteNorth;
        } else {
            return 0.0;
        }
    }
}
