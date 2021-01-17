package com.hapagLloyd.recruitmentTask;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Rate {
    private String id;
    private Double rate;
    private LocalDate date;
    private LocalDate lookupDate;
    private String originCurrency;
    private String targetCurrency;

    public Rate() {
    }

    public Rate(LocalDate date, Double rate) {
        this.date = date;
        this.rate = rate;
        this.lookupDate = LocalDate.now();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Rate))
            return false;
        Rate rate = (Rate) object;
        return Objects.equals(this.id, rate.id)
                && Objects.equals(this.rate, rate.rate)
                && Objects.equals(this.date, rate.date)
                && Objects.equals(this.lookupDate, rate.lookupDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.rate, this.date, this.lookupDate);
    }

    @Override
    public String toString() {
        return "Rate{" + "id=" + this.id + ", rate='" + this.rate + '\'' + ", date='" + this.date + '\'' + '}'; //TODO finish
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLookupDate(LocalDate lookupDate) {
        this.lookupDate = lookupDate;
    }

    public Double getRate() {
        return rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getLookupDate() {
        return lookupDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
