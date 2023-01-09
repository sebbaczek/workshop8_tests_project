package org.example.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Value
public class MortgageReference {

    BigDecimal referenceAmount;
    BigDecimal referenceDuration;

}
