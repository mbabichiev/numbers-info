package com.info.numbers.search.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Number {

    @JsonProperty("Number")
    private int number;

    @JsonProperty("Trivial")
    private String triviaInfo;

    @JsonProperty("Math")
    private String mathInfo;

    @JsonProperty("Year")
    private String yearInfo;

}
