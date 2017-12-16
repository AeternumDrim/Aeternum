package com.pedrodrim.universegeneration.controller;

import com.pedrodrim.universegeneration.model.ProceduralFactory;
import com.pedrodrim.universegeneration.model.ProceduralGeneration;
import com.pedrodrim.universegeneration.model.City;
import com.pedrodrim.universegeneration.model.Economy;
import java.util.Random;

public class CityFactory implements ProceduralFactory {

    private Random random;
    private RandomString randomString;

    private int maxNameSize;
    private int minNameSize;
    private int maxHomeAmmount;
    private int minHomeAmmount;

    public CityFactory() {
        this.random = new Random();
        this.randomString = new RandomString();

        this.maxNameSize = 8;
        this.minNameSize = 4;
        this.maxHomeAmmount = 100;
        this.minHomeAmmount = 10;
    }

    public void setMaxNameSize(int maxNameSize) {
        if (maxNameSize > this.minNameSize) {
            this.maxNameSize = maxNameSize;
        }
    }

    public void setMinNameSize(int minNameSize) {
        if (minNameSize <= 0) {
            this.minNameSize = minNameSize;
        }
    }

    public void setMaxHomeAmmount(int maxHomeAmmount) {
        if (maxHomeAmmount > this.minHomeAmmount) {
            this.maxHomeAmmount = maxHomeAmmount;
        }
    }

    @Override
    public ProceduralGeneration create() {

        int nameSize = this.minNameSize + this.random.nextInt(this.maxNameSize);
        int ammount = this.minHomeAmmount + this.random.nextInt(this.maxHomeAmmount);

        String placeName = this.randomString.generateName(nameSize);

        Economy economy = RandomizeEnum.randomEconomy();

        ProceduralGeneration city = new City(placeName, economy, ammount);

        return city;
    }
}
