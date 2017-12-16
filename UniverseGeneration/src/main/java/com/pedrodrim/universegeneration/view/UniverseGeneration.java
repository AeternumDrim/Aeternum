package com.pedrodrim.universegeneration.view;

import com.pedrodrim.universegeneration.controller.CityFactory;
import com.pedrodrim.universegeneration.controller.HomeFactory;
import com.pedrodrim.universegeneration.controller.HumanFactory;
import com.pedrodrim.universegeneration.controller.PersonMediator;
import com.pedrodrim.universegeneration.controller.PlaceMediator;
import com.pedrodrim.universegeneration.controller.WorldPopulator;
import com.pedrodrim.universegeneration.model.Display;
import com.pedrodrim.universegeneration.model.GenealogyTree;
import com.pedrodrim.universegeneration.model.Mediator;
import com.pedrodrim.universegeneration.model.ProceduralGeneration;

public class UniverseGeneration {

    public static double AVOID_RATE;
    public static int DEEP_LAYER;
    public static int MAX_NAME_SIZE;
    public static int MIN_NAME_SIZE;
    public static int MAX_HOME_AMMOUNT_PER_CITY;
    public static String OUTPUT_PERSON_FILE_NAME;
    public static String OUTPUT_PLACE_FILE_NAME;

    public UniverseGeneration() {

        this.AVOID_RATE = 0.33;
        this.DEEP_LAYER = 20;
        this.MAX_NAME_SIZE = 8;
        this.MIN_NAME_SIZE = 3;
        this.MAX_HOME_AMMOUNT_PER_CITY = 10;
        this.OUTPUT_PERSON_FILE_NAME = "person.csv";
        this.OUTPUT_PLACE_FILE_NAME = "place.csv";
    }

    public void generateRandomCity() {

        HumanFactory humanFactory = new HumanFactory();
        humanFactory.setMaxNameSize(this.MAX_NAME_SIZE);
        humanFactory.setMinNameSize(this.MIN_NAME_SIZE);

        WorldPopulator world = new WorldPopulator(humanFactory);
        GenealogyTree population = world.startGeneration(this.DEEP_LAYER);

        CityFactory cityFactory = new CityFactory();
        cityFactory.setMaxNameSize(this.MAX_NAME_SIZE);
        cityFactory.setMinNameSize(this.MIN_NAME_SIZE);
        cityFactory.setMaxHomeAmmount(this.MAX_HOME_AMMOUNT_PER_CITY);

        ProceduralGeneration city = cityFactory.create();

        HomeFactory homeFactory = new HomeFactory();
        homeFactory.setMaxNameSize(this.MAX_NAME_SIZE);
        homeFactory.setMinNameSize(this.MIN_NAME_SIZE);

        Mediator placeMediator = new PlaceMediator(homeFactory);
        city = placeMediator.call(city);

        Mediator personMediator = new PersonMediator(population, this.AVOID_RATE);
        city = personMediator.call(city);

        Display display = new MyDisplay(
                this.OUTPUT_PERSON_FILE_NAME,
                this.OUTPUT_PLACE_FILE_NAME
        );

        display.display(city);
    }

    public void update_AVOID_RATE(double RANDOM_RATE) {
        UniverseGeneration.AVOID_RATE = RANDOM_RATE;
    }

    public void update_DEEP_LAYER(int DEEP_LAYER) {
        UniverseGeneration.DEEP_LAYER = DEEP_LAYER;
    }

    public void update_MAX_NAME_SIZE(int MAX_NAME_SIZE) {
        UniverseGeneration.MAX_NAME_SIZE = MAX_NAME_SIZE;
    }

    public void update_MIN_NAME_SIZE(int MIN_NAME_SIZE) {
        UniverseGeneration.MIN_NAME_SIZE = MIN_NAME_SIZE;
    }

    public void update_MAX_HOME_AMMOUNT_PER_CITY(int MAX_HOME_AMMOUNT_PER_CITY) {
        UniverseGeneration.MAX_HOME_AMMOUNT_PER_CITY = MAX_HOME_AMMOUNT_PER_CITY;
    }

    public void update_OUTPUT_PERSON_FILE_NAME(String OUTPUT_PERSON_FILE_NAME) {
        UniverseGeneration.OUTPUT_PERSON_FILE_NAME = OUTPUT_PERSON_FILE_NAME;
    }

    public void update_OUTPUT_PLACE_FILE_NAME(String OUTPUT_PLACE_FILE_NAME) {
        UniverseGeneration.OUTPUT_PLACE_FILE_NAME = OUTPUT_PLACE_FILE_NAME;
    }

}
