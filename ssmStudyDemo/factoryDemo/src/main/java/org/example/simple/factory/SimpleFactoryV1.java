package org.example.simple.factory;

import org.example.abstratTest.pojo.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class SimpleFactoryV1 {

    private Map<String,Class> map = new HashMap<>();

    public void register(String typeName,Class clazz){
        map.put(typeName,clazz);
    }

    public Vehicle create(String typeName) throws IllegalAccessException, InstantiationException {
        return (Vehicle) map.get(typeName).newInstance();
    }
}
