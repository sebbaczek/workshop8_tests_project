package org.example.mortgage.services;

import org.example.mortgage.model.InputData;
import org.example.mortgage.model.Rate;

import java.util.List;

public interface RateCalculationService {

    List<Rate> calculate(InputData inputData);
}
