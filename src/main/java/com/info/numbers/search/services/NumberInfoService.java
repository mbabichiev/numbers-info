package com.info.numbers.search.services;

import com.info.numbers.search.api.NumberApi;
import com.info.numbers.search.models.Number;
import com.info.numbers.search.repositories.NumberInfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class NumberInfoService {

    private NumberApi numberApi;
    private NumberInfoRepository numberInfoRepository;

    public Number getFullNumberInfo(int value) {

        if(numberInfoRepository.existsById(value)) {
            return numberInfoRepository.findById(value).orElseThrow();
        }

        Number number = Number.builder()
                .number(value)
                .triviaInfo(numberApi.getTriviaAboutNumber(value))
                .mathInfo(numberApi.getMathAboutNumber(value))
                .yearInfo(numberApi.getYearAboutNumber(value))
                .build();

        numberInfoRepository.save(number);
        return number;
    }

}
