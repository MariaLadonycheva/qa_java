package com.example;

import java.util.List;


public class Feline extends Animal implements Predator {
    private final Predator predator;

    public Feline(Predator predator) {
        this.predator = predator;
    }

    @Override
    public List<String> eatMeat() throws Exception {
        return predator.eatMeat(); // Use the mocked predator
    }
    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
