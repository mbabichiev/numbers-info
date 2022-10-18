package com.info.numbers.search.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "numbers")
public class Number {

    @Id
    @JsonProperty("Number")
    @Column(name = "number")
    private int number;

    @JsonProperty("Trivial")
    @Column(name = "trivia")
    private String triviaInfo;

    @JsonProperty("Math")
    @Column(name = "math")
    private String mathInfo;

    @JsonProperty("Year")
    @Column(name = "year")
    private String yearInfo;

}
