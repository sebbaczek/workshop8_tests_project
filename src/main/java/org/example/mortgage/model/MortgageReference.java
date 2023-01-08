package org.example.mortgage.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class MortgageReference {

    BigDecimal referenceAmount;
    BigDecimal referenceDuration;

}
