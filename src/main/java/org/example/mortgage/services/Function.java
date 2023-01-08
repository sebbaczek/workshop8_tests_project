package org.example.mortgage.services;

import org.example.mortgage.model.Rate;

import java.math.BigDecimal;

public interface Function {

    BigDecimal calculate(Rate rate);
}
