package org.example.mortgage.services;

import org.example.mortgage.model.InputData;
import org.example.mortgage.model.Rate;
import org.example.mortgage.model.RateAmounts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ConstantAmountsCalculationServiceImplTest {
        private ConstantAmountsCalculationService  constantAmountsCalculationService;
        
        @BeforeEach
        public void setup() {
                
                this.constantAmountsCalculationService = new ConstantAmountsCalculationServiceImpl();
        }
        
        
        @Test
        void calculate() {
                // given
                InputData inputData = TestData.someInputData();
                RateAmounts expected = TestData.someRateAmounts();
        
                // when
                RateAmounts result = constantAmountsCalculationService.calculate(inputData, null);
        
                // then
                Assertions.assertEquals(expected, result);
        }
        
        @Test
        void testCalculate() {
                // given
                InputData inputData = TestData.someInputData();
                Rate rate = TestData.someRate();
                RateAmounts expected = TestData.someRateAmounts()
                                               .withRateAmount(new BigDecimal("3303.45"))
                                               .withInterestAmount(new BigDecimal("2483.87"))
                                               .withCapitalAmount(new BigDecimal("819.58"));
        
                // when
                RateAmounts result = constantAmountsCalculationService.calculate(inputData, null, rate);
        
                // then
                Assertions.assertEquals(expected, result);
        }
}