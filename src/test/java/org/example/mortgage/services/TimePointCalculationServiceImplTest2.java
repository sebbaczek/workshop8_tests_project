package org.example.mortgage.services;

import org.example.mortgage.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class TimePointCalculationServiceImplTest2 {
        
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
        
        @ParameterizedTest
        @MethodSource(value = "testMortgageData")
//        void testCalculate(Object[] testData) {
        void calculateTimePointForOtherRates(LocalDate expectedDate, BigDecimal rateNumber, BigDecimal year, BigDecimal month, LocalDate date) {
//                Rate rate = someRate().withTimePoint(timePoint);
//                TimePoint timePoint = someTimePoint()
//                TimePoint expectedTimePoint = someTimePoint()
//                .withYear((BigDecimal) testData[2])
//               .withMonth((BigDecimal) testData[3])
//               .withDate((LocalDate) testData[0]);
                
                TimePoint expectedTimePoint = someTimePoint()
                .withYear(year)
               .withMonth(month)
               .withDate(date);
                
                
//                Rate rate = Rate.builder().timePoint( someTimePoint()).build();
                Rate rate = someRate()
                                    .withTimePoint(expectedTimePoint);
                
//                TimePoint expected = expectedTimePoint.withDate(expectedTimePoint.getDate().plus(1, ChronoUnit.MONTHS));
               TimePoint expected = expectedTimePoint.withDate(expectedDate);
                
                // when
                TimePoint result = timePointCalculationService.calculate(rateNumber, rate);
                
                // then
                Assertions.assertEquals(expected, result);
                
                
                
        }
        public static Stream<Arguments> testMortgageData() {
                return Stream.of(
                        arguments(
                                LocalDate.of(2010, 2, 1),
                                BigDecimal.valueOf(12),
                                BigDecimal.valueOf(1),
                                BigDecimal.valueOf(12),
                                LocalDate.of(2010, 1, 1)),
                        arguments(
                                LocalDate.of(2010, 2, 1),
                                BigDecimal.valueOf(15),
                                BigDecimal.valueOf(2),
                                BigDecimal.valueOf(3),
                                LocalDate.of(2010, 1, 1)),
                        arguments(
                                LocalDate.of(2013, 10, 1),
                                BigDecimal.valueOf(76),
                                BigDecimal.valueOf(7),
                                BigDecimal.valueOf(4),
                                LocalDate.of(2013, 9, 1))
                );
        }
//        public static Object[][] testMortgageData(){
//        return new Object[][]{
//                {LocalDate.of(2020,1,1),BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE},
//                {},
//                {},
//                {},
//                {}
//
//        };
//        }
        
        
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