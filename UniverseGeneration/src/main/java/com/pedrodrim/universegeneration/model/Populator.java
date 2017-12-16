package com.pedrodrim.universegeneration.model;

public interface Populator {
    
    GenealogyTree startGeneration(int maxGeneration);
    int layerSize();
}
