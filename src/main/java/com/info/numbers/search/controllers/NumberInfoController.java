package com.info.numbers.search.controllers;

import com.info.numbers.search.models.Number;
import com.info.numbers.search.services.NumberInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NumberInfoController {

    private NumberInfoService numberInfoService;

    @GetMapping("/{value}")
    @ResponseStatus(HttpStatus.OK)
    public Number getNumberInfo(@PathVariable int value) {
        return numberInfoService.getFullNumberInfo(value);
    }

}
