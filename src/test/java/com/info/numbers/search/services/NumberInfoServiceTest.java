package com.info.numbers.search.services;

import com.info.numbers.search.api.NumberApi;
import com.info.numbers.search.models.Number;
import com.info.numbers.search.repositories.NumberInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class NumberInfoServiceTest {

    private static NumberInfoRepository numberInfoRepository;
    private static NumberApi numberApi;
    private static NumberInfoService numberInfoService;

    private int testId = 1;
    private String testTrivialInfo = "Trivial";
    private String testMathInfo = "Math";
    private String testYearInfo = "Year";


    @BeforeAll
    static void setup() {
        numberInfoRepository = Mockito.mock(NumberInfoRepository.class);
        numberApi = Mockito.mock(NumberApi.class);
        numberInfoService = new NumberInfoService(numberInfoRepository, numberApi);
    }


    @Test
    void getNumberInfoFromDB() {

        Number sourceNumber = Number.builder()
                .number(testId)
                .triviaInfo(testTrivialInfo)
                .mathInfo(testMathInfo)
                .yearInfo(testYearInfo)
                .build();

        Mockito.doReturn(true)
                .when(numberInfoRepository)
                .existsById(testId);

        Mockito.doReturn(Optional.of(sourceNumber))
                .when(numberInfoRepository)
                .findById(testId);

        Number expectedNumber = Number.builder()
                .number(testId)
                .triviaInfo(testTrivialInfo)
                .mathInfo(testMathInfo)
                .yearInfo(testYearInfo)
                .build();

        Number actualNumber = numberInfoService.getFullNumberInfo(testId);

        Assertions.assertEquals(actualNumber, expectedNumber);
    }


    @Test
    void getNumberFromAPI() {

        Number sourceNumber = Number.builder()
                .number(testId)
                .triviaInfo(testTrivialInfo)
                .mathInfo(testMathInfo)
                .yearInfo(testYearInfo)
                .build();

        Mockito.doReturn(false)
                .when(numberInfoRepository)
                .existsById(testId);

        Mockito.doReturn(testTrivialInfo)
                .when(numberApi)
                .getTriviaAboutNumber(testId);

        Mockito.doReturn(testMathInfo)
                .when(numberApi)
                .getMathAboutNumber(testId);

        Mockito.doReturn(testYearInfo)
                .when(numberApi)
                .getYearAboutNumber(testId);

        Number expectedNumber = Number.builder()
                .number(testId)
                .triviaInfo(testTrivialInfo)
                .mathInfo(testMathInfo)
                .yearInfo(testYearInfo)
                .build();

        Number actualNumber = numberInfoService.getFullNumberInfo(testId);

        Assertions.assertEquals(actualNumber, expectedNumber);

        Mockito.verify(numberInfoRepository, Mockito.times(1))
                .save(Mockito.eq(sourceNumber));
    }

}
