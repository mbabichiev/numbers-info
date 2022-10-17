package com.info.numbers.search.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.client.RestTemplate;


@Component
public class NumberApi {

    private final String NUMBER_API_URL = "http://numbersapi.com";
    private final RestTemplate restTemplate;

    public NumberApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    private String sendRequest(String url) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder
                .fromHttpUrl(url)
                .encode().toUriString();

        return restTemplate.exchange(urlTemplate, HttpMethod.GET, httpEntity, String.class)
                .getBody();
    }


    public String getTriviaAboutNumber(int number) {
        return sendRequest(NUMBER_API_URL + "/" + number + "/trivia");
    }


    public String getMathAboutNumber(int number) {
        return sendRequest(NUMBER_API_URL + "/" + number + "/math");
    }


    public String getYearAboutNumber(int number) {
        return sendRequest(NUMBER_API_URL + "/" + number + "/year");
    }

}
