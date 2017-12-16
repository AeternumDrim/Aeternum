package com.pedrodrim.universegeneration.model;

public enum Regency {
    WARRIOR("Warrior"), WIZARD("Wizard"), 
    ORACLE("Oracle"), WILY("Wily"), 
    SHOOTER("Shooter"), TAMER("Tamer"),
    ILLUSIONIST("Illusionist"), SUMMONER("Summoner"),
    METAPHISIC("Metaphisic"), RUNIC("Runic"),
    GRUNPH("Grunph"), NECROMANCER("Necromancer"), ARCAN("Arcan");

    private String value;

    Regency(String value) {
        this.value = value;
    }

    public String getName() {
        return this.value;
    }
}
