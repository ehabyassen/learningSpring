package com.luv2code.aopDemo.service;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire) throw new RuntimeException("Major accident! Highway is closed!");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Expect heavy traffic this morning...";
    }
}
