package org.example.mortgage.services;

import org.example.mortgage.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TimePointCalculationServiceImplTest {
        
        private TimePointCalculationService timePointCalculationService;
        
        @BeforeEach
        public void setup() {
                this.timePointCalculationService = new TimePointCalculationServiceImpl();
        }
        
        @Test
        void calculate() {
//                given
                InputData inputData = someInputData();
//                TimePoint expected = TestData.someTimePoint();
                
                //przykładowe dane można zbudować dodając @Builder i @AllArgsConstructor w danej klasie:
                TimePoint timePoint = someTimePoint();

//                when
                TimePoint result = timePointCalculationService.calculate(BigDecimal.valueOf(1), inputData);
                
                //                then
                
                Assertions.assertEquals(timePoint, result);
                
        }
        
        @Test
        void testCalculate() {
        
//                Rate rate = someRate().withTimePoint(timePoint);
//                TimePoint timePoint = someTimePoint()
                TimePoint expectedTimePoint = someTimePoint()
                .withYear(BigDecimal.ONE)
               .withMonth(BigDecimal.ONE)
                                                      .withDate(LocalDate.of(2020,1,1));
                
                
//                Rate rate = Rate.builder().timePoint( someTimePoint()).build();
                Rate rate = someRate()
                                    .withTimePoint(expectedTimePoint);
                
                TimePoint expected = expectedTimePoint.withDate(expectedTimePoint.getDate().plus(1, ChronoUnit.MONTHS));
                
                // when
                TimePoint result = timePointCalculationService.calculate(BigDecimal.ONE, rate);
                
                // then
                Assertions.assertEquals(expected, result);
        }
        
        private Rate someRate() {
                return Rate.builder()
                               .timePoint(someTimePoint())
                               .build();
        }
        
        private TimePoint someTimePoint() {
                return TimePoint.builder()
                               .year(BigDecimal.ONE)
                               .month(BigDecimal.ONE)
                               .date(LocalDate.of(2010, 5, 10))
                               .build();
        }
        
        //        wklejenie danych przykładowych używanych w inputdata
        public InputData someInputData() {
                return InputData.builder()
                               .repaymentStartDate(LocalDate.of(2020, 12, 10))
                               .wiborPercent(BigDecimal.valueOf(1.70))
                               .amount(BigDecimal.valueOf(301953.46))
                               .monthsDuration(BigDecimal.valueOf(180))
                               .rateType(MortgageType.CONSTANT)
                               .marginPercent(BigDecimal.valueOf(1.6))
                               .overpaymentProvisionPercent(BigDecimal.valueOf(3))
                               .overpaymentProvisionMonths(BigDecimal.valueOf(36))
                               .overpaymentStartMonth(BigDecimal.valueOf(1))
                               .overpaymentSchema(Map.of(
                                       2, BigDecimal.valueOf(10000),
                                       3, BigDecimal.valueOf(10000),
                                       5, BigDecimal.valueOf(10000),
                                       6, BigDecimal.valueOf(10000),
                                       7, BigDecimal.valueOf(10000))
                               )
                               .overpaymentReduceWay(Overpayment.REDUCE_PERIOD)
                               .mortgagePrintPayoffsSchedule(true)
                               .mortgageRateNumberToPrint(1)
                               .build();
        }
        
        
}