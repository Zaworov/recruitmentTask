package com.hapagLloyd.recruitmentTask;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RateRespond {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final LocalDate date;
    private final Double rate;
    private final LocalDate searchDate;
//    @Autowired //TODO make it autowired
    FrankfurterApiService frankfurterApiServive = new FrankfurterApiService();

    public RateRespond(String stringDate){
        this.searchDate = LocalDate.now();
        this.date = LocalDate.parse(stringDate, DATE_FORMAT);
        this.rate = frankfurterApiServive.getRate(date);
        // todo save to historical rates collection
    }

//    public LocalDate getSearchDate() { return searchDate; }

    public Double getRate(){
        return rate;
    }

//    public LocalDate getDate(){
//        return date;
//    }
}

