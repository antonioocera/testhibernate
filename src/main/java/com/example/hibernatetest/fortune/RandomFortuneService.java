package com.example.hibernatetest.fortune;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // creare un array di stringhe
    private String[] data = {
            "String 1", "String 2", "String 3"
    };

    // generare un numero random
    private Random myRandom = new Random();

    @Override
    public String getFortune() {

        // recupera una stringa random dall'array
        int index = myRandom.nextInt(data.length);
        String theFortune = data[index];
        return theFortune;

    }
}
