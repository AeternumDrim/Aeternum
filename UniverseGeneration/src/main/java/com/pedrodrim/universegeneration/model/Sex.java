package com.pedrodrim.universegeneration.model;

public enum Sex {
    MALE("Male"), FEMALE("Female");

    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String getName() {
        return this.value;
    }
}
