package com.raqib.rs_crud.controller;

import com.raqib.rs_crud.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "%s Pharmaceutical";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Incepta") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
