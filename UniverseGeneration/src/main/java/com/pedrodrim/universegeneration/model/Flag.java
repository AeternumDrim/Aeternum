package com.pedrodrim.universegeneration.model;

public enum Flag {
    
    INT("int"), STRING("String"), DOUBLE("double");
    
    private String value;
    
    Flag(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
}
