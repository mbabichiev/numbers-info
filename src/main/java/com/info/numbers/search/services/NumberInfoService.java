package com.info.numbers.search.services;

import com.info.numbers.search.api.NumberApi;
import com.info.numbers.search.models.Number;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class NumberInfoService {

    private NumberApi numberApi;


    public Number getFullNumberInfo(int value) {



        return Number.builder()
                .number(value)
                .triviaInfo(numberApi.getTriviaAboutNumber(value))
                .mathInfo(numberApi.getMathAboutNumber(value))
                .yearInfo(numberApi.getYearAboutNumber(value))
                .build();

    }

}
