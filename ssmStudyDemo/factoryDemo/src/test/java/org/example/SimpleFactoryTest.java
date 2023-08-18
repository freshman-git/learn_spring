package org.example;

import org.example.simple.factory.SimpleVehicleFactory;
import org.example.simple.pojo.Vehicle;
import org.junit.Test;

public class SimpleFactoryTest {


    @Test
    public void testSimpleFactory(){
        SimpleVehicleFactory simpleVehicleFactory = new SimpleVehicleFactory();
        Vehicle bike = simpleVehicleFactory.createVehicle("BIKE");
        System.out.println(bike);
    }
}
