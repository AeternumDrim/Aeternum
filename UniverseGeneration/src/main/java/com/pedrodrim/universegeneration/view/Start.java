package com.pedrodrim.universegeneration.view;

public class Start {

    public static void main(String[] args) {

        UniverseGeneration universe = new UniverseGeneration();
        universe.update_MAX_HOME_AMMOUNT_PER_CITY(50);
        universe.generateRandomCity();
    }
}
