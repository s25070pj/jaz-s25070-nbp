package com.example.jazs25070nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id")
    private Long id;
    @Schema(description = "currency")
    private String currency;
    @Schema(description = "rate")
    private BigDecimal rate;
    @Schema(description = "currency rate date")
    private LocalDate date;
    @Schema(description = "currency rate time")
    private LocalDateTime timestamp;


    public CurrencyRate(String currency, BigDecimal rate, LocalDate date, LocalDateTime timestamp) {
        this.currency = currency;
        this.rate = rate;
        this.date = date;
        this.timestamp = timestamp;
    }

    public CurrencyRate() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}


