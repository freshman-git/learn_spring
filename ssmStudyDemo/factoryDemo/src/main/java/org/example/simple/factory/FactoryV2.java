package org.example.simple.factory;

import org.example.abstratTest.pojo.Bike;
import org.example.abstratTest.pojo.Car;
import org.example.abstratTest.pojo.Truck;
import org.example.abstratTest.pojo.Vehicle;

public class FactoryV2 extends FactoryMethod{


    @Override
    protected Vehicle getInstance(String typeName) {
        if ("car".equals(typeName)){
            return new Car();
        }else if ("bike".equals(typeName)){
            return new Bike();
        }else return new Truck();
    }
}
