package org.example.mortgage.model;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class TimePoint {

    BigDecimal year;
    BigDecimal month;
    LocalDate date;

}
