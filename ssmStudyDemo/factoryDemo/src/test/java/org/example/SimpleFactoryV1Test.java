package org.example;

import org.example.abstratTest.pojo.Car;
import org.example.abstratTest.pojo.Vehicle;
import org.example.simple.factory.SimpleFactoryV1;
import org.junit.Test;

public class SimpleFactoryV1Test {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        SimpleFactoryV1 simpleFactoryV1 = new SimpleFactoryV1();
        simpleFactoryV1.register("car", Car.class);
        Vehicle car = simpleFactoryV1.create("car");
        System.out.println(car);
    }
}
