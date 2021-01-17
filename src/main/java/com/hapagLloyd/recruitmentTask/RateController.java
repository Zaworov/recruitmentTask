package com.hapagLloyd.recruitmentTask;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {

    @GetMapping("getSpecificDateRate")
    public RateRespond rate(@RequestParam String date){ //TODO add default as today
        return new RateRespond(date);
    }
}
