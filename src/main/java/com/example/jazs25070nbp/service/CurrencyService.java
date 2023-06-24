package com.example.jazs25070nbp.service;


import com.example.jazs25070nbp.model.CurrencyRate;

import com.example.jazs25070nbp.repository.CurrencyRateRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDate;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;
    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyService(RestTemplate restTemplate, CurrencyRateRepository currencyRateRepository) {
        this.restTemplate = restTemplate;
        this.currencyRateRepository = currencyRateRepository;
    }

    public void addRateToBase(CurrencyRate currencyRate){
        currencyRateRepository.save(currencyRate);
    }


    public CurrencyRate getCurrencyRateFromNbpApi(String currency, LocalDate startDate, LocalDate endDate) {
        String apiUrl = "https://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + startDate.toString() + "/" + endDate.toString();
     //   addRateToBase();
        return restTemplate.getForObject(apiUrl, CurrencyRate.class);
    }
}
