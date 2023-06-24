package com.example.jazs25070nbp.controller;

import com.example.jazs25070nbp.model.CurrencyRate;
import com.example.jazs25070nbp.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbpcurrency")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

        @Operation(summary = "Get average rate for currency for chosen days", description = "Write only currency code," +
                "dont write EURO, just write eur," +
                " dollar - usd," +
                " złoty - pln ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content),
            @ApiResponse(responseCode = "400", description = "Something went wrong", content = @Content),
            @ApiResponse(responseCode = "404", description = "Currency not found", content = @Content)

    })
    @GetMapping("/{currency}/{startDate}/{endDate}")
    public ResponseEntity<CurrencyRate> getAverageRateForCurrency(
            @PathVariable String currency,
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate endDate) {
        CurrencyRate currencyRate = currencyService.getCurrencyRateFromNbpApi(currency, startDate, endDate);
        if (currencyRate == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currencyRate);
    }

}
