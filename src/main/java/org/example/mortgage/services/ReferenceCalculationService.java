package org.example.mortgage.services;

import org.example.mortgage.model.InputData;
import org.example.mortgage.model.MortgageReference;
import org.example.mortgage.model.Rate;
import org.example.mortgage.model.RateAmounts;

public interface ReferenceCalculationService {

    MortgageReference calculate(RateAmounts rateAmounts, InputData inputData);

    MortgageReference calculate(RateAmounts rateAmounts, final InputData inputData, Rate previousRate);

}
