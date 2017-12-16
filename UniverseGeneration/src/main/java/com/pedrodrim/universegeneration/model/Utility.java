package com.pedrodrim.universegeneration.model;

public enum Utility {
    INN("Inn", 10), PUB("Pub", 25), SHOP("Shop", 10),
    SMALL_HOUSE("Small house", 5), MEDIUM_HOUSE("Medium house", 10),
    BIG_HOUSE("Big house", 20), ABANDONED("Abandoned", 20);
    
    private String value;
    private int size;
    
    Utility(String value, int size){
        this.value = value;
        this.size = size;
    }
    
    public String getName(){
        return this.value;
    }
    
    public int getSize(){
        return this.size;
    }
}
