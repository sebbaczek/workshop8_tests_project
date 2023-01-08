package org.example.mortgage.services;

import org.example.mortgage.model.InputData;
import org.example.mortgage.model.MortgageResidual;
import org.example.mortgage.model.Rate;
import org.example.mortgage.model.RateAmounts;

public interface ResidualCalculationService {

    MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData);

    MortgageResidual calculate(RateAmounts rateAmounts, final InputData inputData, Rate previousRate);

}
