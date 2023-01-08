package org.example.mortgage.services;

import org.example.mortgage.model.InputData;
import org.example.mortgage.model.Rate;
import org.example.mortgage.model.TimePoint;

import java.math.BigDecimal;

public interface TimePointCalculationService {

    TimePoint calculate(final BigDecimal rateNumber, final InputData inputData);

    TimePoint calculate(BigDecimal rateNumber, Rate previousRate);

}
