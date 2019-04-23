package com.example.leitnerbox.model;

import java.util.ArrayList;
import java.util.List;

public class Box {

    String boxNumber;
    String boxTotalCards;


    public Box(String boxNumber, String boxTotalCards) {
        this.boxNumber = boxNumber;
        this.boxTotalCards = boxTotalCards;
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getBoxTotalCards() {
        return boxTotalCards;
    }

    public void setBoxTotalCards(String boxTotalCards) {
        this.boxTotalCards = boxTotalCards;
    }
}
