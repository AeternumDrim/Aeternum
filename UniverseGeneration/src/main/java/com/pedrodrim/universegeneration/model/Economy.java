package com.pedrodrim.universegeneration.model;

public enum Economy {
    TRADE("Trade", 100), MINNING("Minning", 100),
    SELF_SUSTAIN("Self sustain", 100), TOURISM("Tourism", 100);

    private String value;
    private int maxPersonOnStreet;

    Economy(String value, int personSize) {
        this.value = value;
        this.maxPersonOnStreet = personSize;
    }

    public String getName() {
        return this.value;
    }
    
    public int getMaxPersonOnStreet(){
        return this.maxPersonOnStreet;
    }
}
