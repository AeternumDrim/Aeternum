package com.pedrodrim.universegeneration.controller;

import com.pedrodrim.universegeneration.model.Person;
import com.pedrodrim.universegeneration.model.PersonFactory;
import com.pedrodrim.universegeneration.model.Human;
import com.pedrodrim.universegeneration.model.Regency;
import com.pedrodrim.universegeneration.model.Sex;
import java.util.Random;

public class HumanFactory implements PersonFactory {

    private Random random;
    private RandomString randomString;

    private int maxNameSize;
    private int minNameSize;

    public HumanFactory() {
        this.random = new Random();
        this.randomString = new RandomString();

        this.maxNameSize = 9;
        this.minNameSize = 3;
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

    @Override
    public Person spawn() {

        int firstNameSize = this.minNameSize + random.nextInt(this.maxNameSize);
        int secondNameSize = this.minNameSize + random.nextInt(this.maxNameSize);

        String personName = this.randomString
                .generatePersonName(firstNameSize, secondNameSize);

        Sex sex = RandomizeEnum.randomSex();
        Regency regency = RandomizeEnum.randomRegency();

        return new Human(personName, sex, regency);
    }

    @Override
    public Person born(Person father, Person mother) {

        int firstNameSize = this.minNameSize + random.nextInt(this.maxNameSize);
        int secondNameSize = this.minNameSize + random.nextInt(this.maxNameSize);
        int age = 0;

        String personName = this.randomString
                .generatePersonName(firstNameSize, secondNameSize);

        Sex sex = RandomizeEnum.randomSex();
        Regency regency = RandomizeEnum.randomRegency();

        Person parent;
        if (this.random.nextBoolean()) {
            parent = father;
        } else {
            parent = mother;
        }

        personName = personName.split(" ")[0];
        String familyName = parent.getName().split(" ")[1];

        personName = personName + " " + familyName;
        Person person = new Human(personName, sex, regency);

        father.setChildren(person);
        mother.setChildren(person);
        person.setFather(father);
        person.setMother(mother);

        return person;
    }
}
