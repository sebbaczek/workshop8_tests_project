package org.example.mortgage.services;

import org.example.mortgage.model.InputData;
import org.example.mortgage.model.Overpayment;

import java.math.BigDecimal;

public interface OverpaymentCalculationService {

    Overpayment calculate(final BigDecimal rateNumber, final InputData inputData);
}
