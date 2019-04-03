package com.example.hibernatetest.fortune;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today it's your lucky day!";
    }
}
