package org.example.simple.factory;

import org.example.abstratTest.pojo.Vehicle;

public abstract class FactoryMethod {

    protected abstract Vehicle getInstance(String typeName);

    public Vehicle create(String typeName){
        Vehicle instance = getInstance(typeName);
        return instance;
    }
}
