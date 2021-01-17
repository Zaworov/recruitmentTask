package com.hapagLloyd.recruitmentTask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class FrankfurterApiService {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String SPECIFIC_DATE_URL = "https://api.frankfurter.app/%DATE%";
    private static final String DEFAULT_TARGET_CURRENCY = "USD";
    private static final String DUMMY_BODY = "{\"amount\":1.0,\"base\":\"EUR\",\"date\":\"2020-01-10\",\"rates\":{\"AUD\":1.6132,\"BGN\":1.9558,\"BRL\":4.5188,\"CAD\":1.4498,\"CHF\":1.0822,\"CNY\":7.6773,\"CZK\":25.265,\"DKK\":7.4731,\"GBP\":0.8481,\"HKD\":8.6137,\"HRK\":7.4445,\"HUF\":333.85,\"IDR\":15264,\"ILS\":3.8476,\"INR\":78.692,\"ISK\":136.6,\"JPY\":121.6,\"KRW\":1286.0,\"MXN\":20.863,\"MYR\":4.5212,\"NOK\":9.8745,\"NZD\":1.6769,\"PHP\":55.998,\"PLN\":4.2462,\"RON\":4.7796,\"RUB\":68.041,\"SEK\":10.551,\"SGD\":1.4969,\"THB\":33.534,\"TRY\":6.5198,\"USD\":1.1091,\"ZAR\":15.8081}}";
//    private static final String DUMMY_BODY = "{\"amount\":1.0,\"base\":\"EUR\",\"date\":\"2020-01-10\",\"rates\":{\"AUD\":1.6132,\"BGN\":1.9558,\"BRL\":4.5188,\"CAD\":1.4498,\"CHF\":1.0822,\"CNY\":7.6773,\"CZK\":25.265,\"DKK\":7.4731,\"GBP\":0.8481,\"HKD\":8.6137,\"HRK\":7.4445,\"HUF\":333.85,\"IDR\":15264,\"ILS\":3.8476,\"INR\":78.692,\"ISK\":136.6,\"JPY\":121.6,\"KRW\":1286.0,\"MXN\":20.863,\"MYR\":4.5212,\"NOK\":9.8745,\"NZD\":1.6769,\"PHP\":55.998,\"PLN\":4.2462,\"RON\":4.7796,\"RUB\":68.041,\"SEK\":10.551,\"SGD\":1.4969,\"THB\":33.534,\"TRY\":6.5198,\"ZAR\":15.8081}}";
    public static final String RATES_JSON_FIELD = "rates";

    private String getRates(LocalDate date) {
//        String url = SPECIFIC_DATE_URL.replace("%DATE%", date.format(DATE_FORMAT));
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//        return response.getBody();
        return DUMMY_BODY;
    }
    public Double getRate(LocalDate date) {
        return getRate(getRates(date), DEFAULT_TARGET_CURRENCY);
    }

    private Double getRate(String rates, String targetCurrency) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode ratesNode;
        try {
            JsonNode rootNode = objectMapper.readTree(DUMMY_BODY);
            ratesNode = rootNode.get(RATES_JSON_FIELD);
        } catch (JsonProcessingException unexpectedJSONformatException) {
            //TODO leave log here
            return null;
        }
        System.out.println(ratesNode.textValue());
        return ratesNode.path(DEFAULT_TARGET_CURRENCY).asDouble();
    }
}
