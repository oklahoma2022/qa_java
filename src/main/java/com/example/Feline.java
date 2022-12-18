package com.example;

import Constsnts.ConstantsAnimal;

import java.util.List;

public class Feline extends Animal implements Predator, KittensInterface {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return ConstantsAnimal.CATS;
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
