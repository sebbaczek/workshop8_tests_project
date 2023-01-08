package org.example.mortgage.services;

import org.example.mortgage.model.InputData;
import org.example.mortgage.model.Overpayment;
import org.example.mortgage.model.Rate;
import org.example.mortgage.model.RateAmounts;

public interface ConstantAmountsCalculationService {

    RateAmounts calculate(InputData inputData, Overpayment overpayment);

    RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
